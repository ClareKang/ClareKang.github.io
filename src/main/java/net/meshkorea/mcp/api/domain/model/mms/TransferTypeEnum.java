package net.meshkorea.mcp.api.domain.model.mms;

/**
 * Created by yjhan on 2017. 7. 5..
 */
public enum TransferTypeEnum {

    SMS(0),
    URL(1),
    MMS(4);

    private int value;

    TransferTypeEnum(int value) {
        this.value = value;
    }
}
