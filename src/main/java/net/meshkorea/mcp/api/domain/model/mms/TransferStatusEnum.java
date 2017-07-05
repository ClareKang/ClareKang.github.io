package net.meshkorea.mcp.api.domain.model.mms;

/**
 * Created by yjhan on 2017. 7. 5..
 *
 *  1:전송 (메시지 초기 입력 상태 )
 *  4:전송중
 *  2:KSKYB 전송완료
 *  3:전송완료 결과수신
 */
public enum TransferStatusEnum {

    REQUEST("1"),
    TRANSFERRING("4"),
    DONE("2"),
    RECEIVE_RESULT("3");

    private String value;

    TransferStatusEnum(String value) {
        this.value = value;
    }
}
