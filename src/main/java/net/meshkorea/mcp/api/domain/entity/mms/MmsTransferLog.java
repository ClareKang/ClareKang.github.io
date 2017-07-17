package net.meshkorea.mcp.api.domain.entity.mms;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by yjhan on 2017. 7. 5..
 * <p>
 * `TRAN_GRP_KEY` VARCHAR(16) NOT NULL COMMENT 'kb_mms_grp FK',
 * `TRAN_MSG_KEY` VARCHAR(16) NOT NULL COMMENT 'PK',
 * `TRAN_PHONE` VARCHAR(15) NOT NULL COMMENT '수신번호',
 * `TRAN_EXTEND` VARCHAR(86) NULL DEFAULT NULL COMMENT '부가데이터 ( G/W로 전송 )',
 * `TRAN_STATUS` CHAR(1) NOT NULL DEFAULT '1' COMMENT '1:전송 (메시지 초기 입력 상태 ) 4:전송중 2:KSKYB 전송완료 3:전송결과수신',
 * `TRAN_DATE` DATETIME NULL DEFAULT NULL COMMENT '전송요청시간',
 * `TRAN_SENDDATE` DATETIME NULL DEFAULT NULL COMMENT 'GW전송시간',
 * `TRAN_REPORTDATE` DATETIME NULL DEFAULT NULL COMMENT '전송결과수신시간',
 * `TRAN_RSLTDATE` DATETIME NULL DEFAULT NULL COMMENT '휴대폰 수신시간(이통사전송값)',
 * `TRAN_RSLT` VARCHAR(5) NULL DEFAULT NULL COMMENT '전송결과코드',
 * `TRAN_END_TELCO` VARCHAR(5) NULL DEFAULT NULL COMMENT '착신망 정보',
 * `TRAN_LOG` CHAR(1) NULL DEFAULT 'N' COMMENT 'default ‘N’  테이블백업관련 Agent사용값',
 * `TRAN_RECEIVER` VARCHAR(20) NULL DEFAULT NULL COMMENT '수신자',
 */
@Getter
@Setter
@Entity
@Table(name = "kb_mms_tran_log")
public class MmsTransferLog implements Serializable {

    @ManyToOne
    @JoinColumn(name = "TRAN_GRP_KEY")
    private MmsGroupLog mmsGroupLog;

    @Id
    @Column(name = "TRAN_MSG_KEY")
    private String transferKey;

    @Column(name = "TRAN_PHONE")
    private String receiverPhone;

    @Column(name = "TRAN_STATUS")
    private String transferStatus;

    @Column(name = "TRAN_DATE")
    private LocalDateTime sendRequestDate;

    @Column(name = "TRAN_SENDDATE")
    private LocalDateTime transferStartDate;

    @Column(name = "TRAN_RSLTDATE")
    private LocalDateTime resultReceptionDate;

    @Column(name = "TRAN_RSLT")
    private String resultCode;

    @Column(name = "TRAN_END_TELCO")
    private String telecommunicationCompany;

    @Column(name = "TRAN_RECEIVER")
    private String receiver;

}
