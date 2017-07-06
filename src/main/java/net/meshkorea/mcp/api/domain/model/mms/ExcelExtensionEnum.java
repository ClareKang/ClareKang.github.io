package net.meshkorea.mcp.api.domain.model.mms;

import lombok.Getter;

/**
 * Created by yjhan on 2017. 7. 6..
 */
@Getter
public enum ExcelExtensionEnum {

    XLS("xls"),
    XLSX("xlsx");

    private String value;

    private ExcelExtensionEnum(String value) {
        this.value = value;
    }

}
