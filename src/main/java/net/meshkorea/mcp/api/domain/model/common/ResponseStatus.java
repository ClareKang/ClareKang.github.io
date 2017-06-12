package net.meshkorea.mcp.api.domain.model.common;

/**
 * Created by reverof on 2017. 6. 12..
 */
public enum ResponseStatus {

    SUCCESS("success"),
    FAIL("fail"),
    ERROR("error");

    private String value;

    ResponseStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
