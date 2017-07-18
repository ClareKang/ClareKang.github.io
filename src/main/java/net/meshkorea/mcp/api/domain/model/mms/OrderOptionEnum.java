package net.meshkorea.mcp.api.domain.model.mms;

/**
 * Created by reverof on 2017-07-17.
 */
public enum OrderOptionEnum {

    NEWEST("최근발송순"),
    SENDING_ORDER("발송회차순"),
    RECEIVER_NAME("수신자명순"),
    RECEIVER_PHONE("수신번호순");

    private String value;

    OrderOptionEnum(String value) {
        this.value = value;
    }

}
