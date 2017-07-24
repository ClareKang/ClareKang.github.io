package net.meshkorea.mcp.api.service.mms;

import net.meshkorea.mcp.api.config.mms.MmsConfiguration;
import net.meshkorea.mcp.api.domain.entity.mms.MmsGroup;
import net.meshkorea.mcp.api.domain.entity.mms.MmsSummary;
import net.meshkorea.mcp.api.domain.entity.mms.MmsTransfer;
import net.meshkorea.mcp.api.domain.entity.mms.MmsTransferLog;
import net.meshkorea.mcp.api.domain.model.common.IntraErrorDto;
import net.meshkorea.mcp.api.domain.model.common.IntraException;
import net.meshkorea.mcp.api.domain.model.common.PageableRequestMapper;
import net.meshkorea.mcp.api.domain.model.mms.*;
import net.meshkorea.mcp.api.domain.repository.MmsGroupRepository;
import net.meshkorea.mcp.api.domain.repository.MmsSummaryRepository;
import net.meshkorea.mcp.api.domain.repository.MmsTransferLogRepository;
import net.meshkorea.mcp.api.domain.repository.MmsTransferRepository;
import net.meshkorea.mcp.api.service.auth.OAuthUserService;
import net.meshkorea.mcp.api.util.excel.ExcelReadComponent;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yjhan on 2017. 7. 6..
 */
@Service
public class MmsService {

    @Autowired
    private MmsConfiguration mmsConfiguration;

    @Autowired
    private MmsGroupRepository mmsGroupRepository;

    @Autowired
    private MmsSummaryRepository mmsSummaryRepository;

    @Autowired
    private MmsTransferRepository mmsTransferRepository;

    @Autowired
    private MmsTransferLogRepository mmsTransferLogRepository;

    @Autowired
    private ExcelReadComponent excelReadComponent;

    @Autowired
    private OAuthUserService oAuthUserService;

    private String makeTransferKey(String base, int index) {
        return String.format(base + "%03d", index);
    }

    private <T> List<T> getSubList(List<T> list, int page, int size) {

        int from = Math.max(0, page * size);
        int to = Math.min(list.size(), (page + 1) * size);

        return list.subList(from, to);
    }

    private Boolean isValidRange(int totalSize, int page, int itemsPerPage) {
        Boolean result = false;
        if (totalSize > 0) {
            int totalPage = totalSize / itemsPerPage;
            if ((totalSize % itemsPerPage) != 0) {
                totalPage += 1;
            }
            if (page < totalPage) {
                result = true;
            }
        }
        return result;
    }

    /**
     * 2) kb_mms_tran -> kb_mms_grp
     */
    private void sendMessage(MmsGroup mmsGroup, List<ReceiverDto> receivers) {
        if (receivers != null && receivers.size() > 0) {
            LocalDateTime requestDate = LocalDateTime.now();
            int index = 1;
            for (ReceiverDto receiver : receivers) {
                MmsTransfer mmsTransfer = new MmsTransfer();
                mmsTransfer.setMmsGroup(mmsGroup);
                mmsTransfer.setTransferKey(makeTransferKey(mmsGroup.getGroupKey(), index++));
                mmsTransfer.setReceiverPhone(receiver.getPhone());
                mmsTransfer.setTransferStatus(TransferStatusEnum.REQUEST.getValue());
                mmsTransfer.setSendRequestDate(requestDate);
                mmsTransfer.setReceiver(receiver.getName());
                mmsTransferRepository.save(mmsTransfer);
            }
        }
    }

    private MmsSendResponse sendMessage(MmsSummary mmsSummary, String message, List<ReceiverDto> receivers) throws IntraException {
        if (mmsSummary != null && receivers != null && receivers.size() > 0) {
            LocalDateTime requestDate = LocalDateTime.now();
            MmsGroup mmsGroup = new MmsGroup();
            mmsGroup.setGroupKey(String.valueOf(System.currentTimeMillis()));
            mmsGroup.setCallbackNumber(mmsConfiguration.getCallbackNumber());
            mmsGroup.setMessage(message);
            mmsGroup.setMmsSummary(mmsSummary);
            mmsGroup.setReceiverCount(receivers.size());
            mmsGroup.setSendRequestDate(requestDate.plusHours(1)); // 1시간 뒤
            mmsGroup.setTransferStatus(TransferStatusEnum.REQUEST.getValue());
            mmsGroup.setTransferType(TransferTypeEnum.MMS.getValue());
            mmsGroupRepository.save(mmsGroup);

            sendMessage(mmsGroup, receivers);

            mmsGroup.setSendRequestDate(requestDate); // 요청시각 변경
            mmsGroupRepository.save(mmsGroup);

            return new MmsSendResponse();
        }
        throw new IntraException("수신번호를 1건 이상 입력하세요.");
    }

    /**
     * 1) mms_summary
     */
    @Transactional
    public MmsSendResponse sendMessage(MmsSendRequest mmsSendRequest) throws IntraException {
        if (mmsSendRequest != null) {
            MmsSummary mmsSummary = new MmsSummary();
            mmsSummary.setMmsSender(oAuthUserService.getCurrentUser().getId());
            mmsSummaryRepository.save(mmsSummary);

            try {
                // 분할 발송
                if (mmsSendRequest.getReceivers().size() > mmsConfiguration.getMaxReceiverAtOnce()) {
                    for (int page = 0; isValidRange(mmsSendRequest.getReceivers().size(), page, mmsConfiguration.getMaxReceiverAtOnce()); ++page) {
                        return sendMessage(mmsSummary, mmsSendRequest.getMessage(), getSubList(mmsSendRequest.getReceivers(), page, mmsConfiguration.getMaxReceiverAtOnce()));
                    }
                } else { // 전체 발송
                    return sendMessage(mmsSummary, mmsSendRequest.getMessage(), mmsSendRequest.getReceivers());
                }
            } catch (IntraException ie) {
                return new MmsSendResponse(new IntraErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, ie.getMessage()));
            }
        } else if (StringUtils.isEmpty(mmsSendRequest.getMessage())) {
            return new MmsSendResponse(new IntraErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, "메세지를 입력해주세요."));
        }
        return new MmsSendResponse(new IntraErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, "수신번호를 1건 이상 입력하세요."));
    }

    public MmsSendResponse sendMessage(MmsSendRequest mmsSendRequest, MultipartFile multipartFile) {
        if (multipartFile != null) {
            try {
                List<ReceiverDto> receivers = excelToReceiverDtos(multipartFile);
                List<ReceiverDto> mmsReceivers = new ArrayList<>();
                for (ReceiverDto receiver : receivers) {
                    if (StringUtils.isNotEmpty(receiver.getPhone())) {
                        mmsReceivers.add(receiver);
                    }
                }
                if (mmsReceivers.size() <= 0) {
                    return new MmsSendResponse(new IntraErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, "수신번호를 1건 이상 입력하세요."));
                }
                if (mmsReceivers.size() > 1000) {
                    return new MmsSendResponse(new IntraErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, "문자는 최대 1000건 까지 발송 가능합니다."));
                }
                mmsSendRequest.setReceivers(mmsReceivers);
            } catch (InvalidFormatException ife) {
                return new MmsSendResponse(new IntraErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, "파일 형식은 xls, xlsx 만 업로드 가능 합니다."));
            } catch (IOException ioe) {
                return new MmsSendResponse(new IntraErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, "액셀 파일 읽기 오류."));
            } catch (NullPointerException npe) {
                return new MmsSendResponse(new IntraErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, "수신번호를 1건 이상 입력하세요."));
            }
        }
        try {
            return sendMessage(mmsSendRequest);
        } catch (IntraException ie) {
            return new MmsSendResponse(new IntraErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, ie.getMessage()));
        }
    }

    public MmsSendResponse sendMessage(String message, MultipartFile multipartFile) {
        if (StringUtils.isNotEmpty(message)) {
            MmsSendRequest mmsSendRequest = new MmsSendRequest(message);
            return sendMessage(mmsSendRequest, multipartFile);
        }
        return new MmsSendResponse(new IntraErrorDto(HttpStatus.INTERNAL_SERVER_ERROR, "메세지를 입력해주세요."));
    }

    @Transactional
    public MmsListResponse sendHistories(MmsListRequest mmsListRequest) {
        Pageable pageable = PageableRequestMapper.getPageRequest(
            mmsListRequest,
            new Sort(Sort.Direction.DESC, "transferKey")
        );

        Page<MmsTransferLog> mmsTransferLogs = mmsTransferLogRepository.search(mmsListRequest, pageable);

        return new MmsListResponse(
            mmsTransferLogs.getNumber(),
            mmsTransferLogs.getSize(),
            mmsTransferLogs.getTotalPages(),
            mmsTransferLogs.getTotalElements(),
            mmsTransferLogs.getContent().stream().map(mmsTransferLog -> {
                return MmsTransferLogMapper.INSTANCE.mmsTransferLogToMmsTransferLogDto(mmsTransferLog);
            }).collect(Collectors.toList())
        );
    }

    public List<List<String>> excelBodies(MmsListRequest mmsListRequest) {
        Pageable pageable = PageableRequestMapper.getPageRequest(
            0,
            1000,
            new Sort(Sort.Direction.DESC, "transferKey")
        );

        Page<MmsTransferLog> mmsTransferLogs = mmsTransferLogRepository.search(mmsListRequest, pageable);

        List<MmsTransferLogDto> rows = mmsTransferLogs.getContent().stream().map(mmsTransferLog -> {
            return MmsTransferLogMapper.INSTANCE.mmsTransferLogToMmsTransferLogDto(mmsTransferLog);
        }).collect(Collectors.toList());

        return MmsExcelDtoMapper.convert(rows);
    }

    public List<String> excelHeader() {
        List<String> result = new ArrayList<>();
        result.add("발송회차");
        result.add("발송일시");
        result.add("수신자명");
        result.add("수신번호");
        result.add("발송자");
        result.add("발송결과");

        return result;
    }

    public String excelFileName() {
        return "history_" + DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").format(LocalDateTime.now());
    }

    public List<ReceiverDto> excelToReceiverDtos(MultipartFile multipartFile) throws IOException, InvalidFormatException {
        return excelReadComponent.readExcelToList(multipartFile, XlsToReceiverDtoMapper::rowOf, 1);
    }

}
