package net.meshkorea.mcp.api.domain.model.mms;

import lombok.Getter;

/**
 * Created by reverof on 2017-07-17.
 */
@Getter
public enum ResultOptionEnum {

    SUCCESS("1000"),
    FAIL("");

    private String value;

    private ResultOptionEnum(String value) {
        this.value = value;
    }

}
