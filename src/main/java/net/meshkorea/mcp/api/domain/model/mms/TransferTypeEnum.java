package net.meshkorea.mcp.api.domain.model.mms;

import lombok.Getter;

/**
 * Created by yjhan on 2017. 7. 5..
 */
@Getter
public enum TransferTypeEnum {

    SMS(0),
    URL(1),
    MMS(4);

    private int value;

    TransferTypeEnum(int value) {
        this.value = value;
    }
}
