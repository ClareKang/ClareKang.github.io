package net.meshkorea.mcp.api.domain.model.auth;

/**
 * Created by reverof on 2017. 6. 19..
 */
public enum GroupListTypeEnum {

    GROUP_NAME("권한 그룹명"),
    GROUP_CODE("권한 그룹 코드");

    private String value;

    GroupListTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
