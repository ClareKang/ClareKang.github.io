package net.meshkorea.mcp.api.domain.model.mms;

/**
 * Created by reverof on 2017-07-17.
 */
public enum ResultOptionEnum {

    SUCCESS("1000"),
    FAIL("");

    private String value;

    private ResultOptionEnum(String value) {
        this.value = value;
    }

}
