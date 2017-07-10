package net.meshkorea.mcp.api.domain.model.mms;

import lombok.Getter;

/**
 * Created by yjhan on 2017. 7. 5..
 */
@Getter
public enum TransferResultEnum {

    SUCCESS("1000");

    private String value;

    TransferResultEnum(String value) {
        this.value = value;
    }
}
