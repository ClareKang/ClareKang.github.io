package net.meshkorea.mcp.api.domain.entity.mms;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.mms.TransferStatusEnum;
import net.meshkorea.mcp.api.domain.model.mms.TransferTypeEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by yjhan on 2017. 7. 5..
 *
 * `TRAN_GRP_KEY` VARCHAR(16) NOT NULL COMMENT 'PK',
 * `TRAN_REFKEY` VARCHAR(20) NULL DEFAULT NULL COMMENT '업체측에서 사용하는 필드',
 * `TRAN_ID` VARCHAR(20) NULL DEFAULT NULL COMMENT '업체측에서 사용하는 필드',
 * `TRAN_CALLBACK` VARCHAR(15) NOT NULL COMMENT '회신번호 ( G/W 전달값 )',
 * `TRAN_SUBJECT` VARCHAR(100) NULL DEFAULT NULL COMMENT 'MMS 전송 제목 ( G/W 전달값 )',
 * `TRAN_MSG` TEXT NOT NULL COMMENT '전송 메세지  ( G/W 전달값 )',
 * `TRAN_DATE` DATETIME NOT NULL COMMENT '전송요청시간',
 * `TRAN_TYPE` INT(11) NOT NULL COMMENT '4 : MMS',
 * `TRAN_STATUS` CHAR(1) NOT NULL DEFAULT '1' COMMENT '1:전송 (메시지 초기 입력 상태 ) 4:전송중 2:KSKYB 전송완료',
 * `TRAN_SENDDATE` DATETIME NULL DEFAULT NULL COMMENT '전송시작일자',
 * `TRAN_RECEIVER_CNT` INT(11) NOT NULL COMMENT '기본 : 1 동보일 경우 전체전송숫자',
 * `TRAN_ETC1` VARCHAR(160) NULL DEFAULT NULL COMMENT '업체측에서 사용하는 필드',
 * `TRAN_ETC2` VARCHAR(160) NULL DEFAULT NULL COMMENT '업체측에서 사용하는 필드',
 * `TRAN_ETC3` VARCHAR(160) NULL DEFAULT NULL COMMENT '업체측에서 사용하는 필드',
 * `TRAN_ETC4` VARCHAR(160) NULL DEFAULT NULL COMMENT '업체측에서 사용하는 필드',
 * `TRAN_ETC5` VARCHAR(160) NULL DEFAULT NULL COMMENT '업체측에서 사용하는 필드',
 * `TRAN_LOG` CHAR(1) NULL DEFAULT 'N' COMMENT 'default ‘N’  테이블백업관련 Agent사용값',
 * `mms_summary_no` INT NOT NULL COMMENT 'mms_summary FK',
 */
@Getter
@Setter
@Entity
@Table(name = "kb_mms_grp")
public class MmsGroup implements Serializable {

    @Id
    @Column(name = "TRAN_GRP_KEY")
    private String groupKey;

    @Column(name = "TRAN_CALLBACK")
    private String callbackNumber;

    @Column(name = "TRAN_SUBJECT")
    private String subject;

    @Column(name = "TRAN_MSG")
    private String message;

    @Column(name = "TRAN_DATE")
    private LocalDateTime sendRequestDate;

    @Enumerated
    @Column(name = "TRAN_TYPE")
    private TransferTypeEnum transferType;

    @Enumerated
    @Column(name = "TRAN_STATUS")
    private TransferStatusEnum transferStatus;

    @Column(name = "TRAN_SENDDATE")
    private LocalDateTime transferStartDate;

    @Column(name = "TRAN_RECEIVER_CNT")
    private Integer receiverCount;

    @ManyToOne
    @JoinColumn(name = "mms_summary_no")
    private MmsSummary mmsSummary;

    @OneToMany(mappedBy = "mmsGroup")
    private List<MmsTransfer> mmsTransfers;
}
