package net.meshkorea.mcp.api.service.mms;

import net.meshkorea.mcp.api.config.mms.MmsConfiguration;
import net.meshkorea.mcp.api.domain.entity.mms.MmsGroup;
import net.meshkorea.mcp.api.domain.entity.mms.MmsSummary;
import net.meshkorea.mcp.api.domain.entity.mms.MmsTransfer;
import net.meshkorea.mcp.api.domain.model.mms.MmsSendRequest;
import net.meshkorea.mcp.api.domain.model.mms.ReceiverDto;
import net.meshkorea.mcp.api.domain.model.mms.TransferStatusEnum;
import net.meshkorea.mcp.api.domain.model.mms.TransferTypeEnum;
import net.meshkorea.mcp.api.domain.repository.MmsGroupRepository;
import net.meshkorea.mcp.api.domain.repository.MmsSummaryRepository;
import net.meshkorea.mcp.api.domain.repository.MmsTransferRepository;
import net.meshkorea.mcp.api.service.auth.OAuthUserService;
import net.meshkorea.mcp.api.util.excel.ExcelReadComponent;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

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
    private ExcelReadComponent excelReadComponent;

    @Autowired
    private OAuthUserService oAuthUserService;

    private String makeTransferKey(String base, int index) {
        return String.format(base + "%3d", index);
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
            int index = 1;
            for (ReceiverDto receiver : receivers) {
                MmsTransfer mmsTransfer = new MmsTransfer();
                mmsTransfer.setMmsGroup(mmsGroup);
                mmsTransfer.setTranferKey(makeTransferKey(mmsGroup.getGroupKey(), index++));
                mmsTransfer.setReceiverPhone(receiver.getPhoneNumber());
                mmsTransfer.setTransferStatus(TransferStatusEnum.REQUEST.getValue());
                mmsTransfer.setSendRequestDate(mmsGroup.getSendRequestDate());
                mmsTransfer.setReceiver(receiver.getName());
                mmsTransferRepository.save(mmsTransfer);
            }
        }
    }

    private void sendMessage(MmsSummary mmsSummary, String message, List<ReceiverDto> receivers) {
        if (mmsSummary != null && receivers != null && receivers.size() > 0) {
            LocalDateTime requestDate = LocalDateTime.now();
            MmsGroup mmsGroup = new MmsGroup();
            mmsGroup.setGroupKey(String.valueOf(System.currentTimeMillis()));
            mmsGroup.setCallbackNumber(mmsConfiguration.getCallbackNumber());
            mmsGroup.setMessage(message);
            mmsGroup.setMmsSummary(mmsSummary);
            mmsGroup.setReceiverCount(receivers.size());
            mmsGroup.setSendRequestDate(LocalDateTime.now());
            mmsGroup.setTransferStatus(TransferStatusEnum.REQUEST.getValue());
            mmsGroup.setTransferType(TransferTypeEnum.MMS.getValue());

            sendMessage(mmsGroup, receivers);

            mmsGroupRepository.save(mmsGroup);
        }
    }

    /**
     * 1) mms_summary
     */
    @Transactional
    public void sendMessage(MmsSendRequest mmsSendRequest) {
        if (mmsSendRequest != null && mmsSendRequest.getReceivers() != null) {
            MmsSummary mmsSummary = new MmsSummary();
            mmsSummary.setMmsSender(oAuthUserService.getCurrentUser().getId());
            mmsSummaryRepository.save(mmsSummary);
            // 분할 발송
            if (mmsSendRequest.getReceivers().size() > mmsConfiguration.getMaxReceiverAtOnce()) {
                for (int page = 0; isValidRange(mmsSendRequest.getReceivers().size(), page, mmsConfiguration.getMaxReceiverAtOnce()); ++page) {
                    sendMessage(mmsSummary, mmsSendRequest.getMessage(), getSubList(mmsSendRequest.getReceivers(), page, mmsConfiguration.getMaxReceiverAtOnce()));
                }
            } else { // 전체 발송
                sendMessage(mmsSummary, mmsSendRequest.getMessage(), mmsSendRequest.getReceivers());
            }
        }
    }

    public void sendMessage(MmsSendRequest mmsSendRequest, MultipartFile multipartFile) throws IOException, InvalidFormatException {
        mmsSendRequest.setReceivers(excelToReceiverDtos(multipartFile));
        sendMessage(mmsSendRequest);
    }

    public List<ReceiverDto> excelToReceiverDtos(MultipartFile multipartFile) throws IOException, InvalidFormatException {
        return excelReadComponent.readExcelToList(multipartFile, ReceiverDto::rowOf);
    }

}
