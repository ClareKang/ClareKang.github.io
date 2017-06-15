package net.meshkorea.mcp.api.domain.model.common;

/**
 * Created by reverof on 2017. 6. 14..
 */
public enum CodesEnum {
    USER_TYPE("사용자 유형"),
    USER_SEARCH_TYPE("사용자 조회 타입");

    private String value;

    CodesEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
