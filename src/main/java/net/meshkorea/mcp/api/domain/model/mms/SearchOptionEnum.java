package net.meshkorea.mcp.api.domain.model.mms;

/**
 * Created by reverof on 2017-07-17.
 */
public enum SearchOptionEnum {

    SENDING_ORDER("발송회차"),
    RECEIVER_PHONE("수신번호"),
    RECEIVER_NAME("수신자명"),
    SENDER("발송자");

    private String value;

    SearchOptionEnum(String value) {
        this.value = value;
    }

}
