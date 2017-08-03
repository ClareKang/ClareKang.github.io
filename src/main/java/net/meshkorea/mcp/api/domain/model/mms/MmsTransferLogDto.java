package net.meshkorea.mcp.api.domain.model.mms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created by yjhan on 2017. 7. 5..
 */
@Getter
@Setter
@NoArgsConstructor
public class MmsTransferLogDto {

    private MmsGroupLogDto mmsGroupLog;

    private String transferKey;

    private String receiverPhone;

    private String transferStatus;

    private LocalDateTime sendRequestDate;

    private LocalDateTime transferStartDate;

    private LocalDateTime resultReceptionDate;

    private LocalDateTime phoneReceptionDate;

    private String resultCode;

    private String telecommunicationCompany;

    private String receiver;

}
