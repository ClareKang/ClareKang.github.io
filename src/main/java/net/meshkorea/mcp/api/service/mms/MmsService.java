package net.meshkorea.mcp.api.service.mms;

import net.meshkorea.mcp.api.config.mms.MmsConfiguration;
import net.meshkorea.mcp.api.domain.entity.mms.MmsGroup;
import net.meshkorea.mcp.api.domain.entity.mms.MmsTransfer;
import net.meshkorea.mcp.api.domain.model.mms.MmsSendRequest;
import net.meshkorea.mcp.api.domain.model.mms.ReceiverDto;
import net.meshkorea.mcp.api.domain.repository.MmsGroupRepository;
import net.meshkorea.mcp.api.domain.repository.MmsSummaryRepository;
import net.meshkorea.mcp.api.domain.repository.MmsTransferRepository;
import net.meshkorea.mcp.api.util.excel.ExcelReadComponent;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    private String makeTransferKey(String base, int index) {
        return String.format(base + "%3d", index);
    }

    /**
     * kb_mms_tran -> kb_mms_grp -> mms_summary
     */
    private void sendMessage(MmsGroup mmsGroup, String message, List<ReceiverDto> receivers) {
        if (receivers != null && receivers.size() > 0) {
            int index = 1;
            String transferKeyBase = String.valueOf(System.currentTimeMillis());
            for (ReceiverDto receiver : receivers) {
                MmsTransfer mmsTransfer = new MmsTransfer();
                mmsTransfer.setMmsGroup(mmsGroup);
                mmsTransfer.setTranferKey(makeTransferKey(transferKeyBase, index++));
            }
        }
    }

    public void sendMessage(MmsSendRequest mmsSendRequest) {
        if (mmsSendRequest != null && mmsSendRequest.getReceivers() != null) {
            // 분할 발송
            if (mmsSendRequest.getReceivers().size() > mmsConfiguration.getMaxReceiverAtOnce()) {

            } else { // 전체 발송

            }
        }
    }

    public List<ReceiverDto> excelToReceiverDto(MultipartFile multipartFile) throws IOException, InvalidFormatException {
        return excelReadComponent.readExcelToList(multipartFile, ReceiverDto::rowOf);
    }

}
