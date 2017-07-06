package net.meshkorea.mcp.api.domain.model.mms;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by yjhan on 2017. 7. 5..
 */
@Getter
@Setter
public class MmsGroupDto {

    private String groupKey;

    private String callbackNumber;

    private String subject;

    private String message;

    private LocalDateTime sendRequestDate;

    private TransferTypeEnum transferType;

    private TransferStatusEnum transferStatus;

    private LocalDateTime transferStartDate;

    private Integer receiverCount;

    private MmsSummaryDto mmsSummary;

    private List<MmsTransferDto> mmsTransfers;

}
