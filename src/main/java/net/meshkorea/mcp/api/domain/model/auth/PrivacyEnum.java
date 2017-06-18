package net.meshkorea.mcp.api.domain.model.auth;

/**
 * Created by reverof on 2017. 6. 18..
 */
public enum PrivacyEnum {

    Y("개인정보 취급"),
    N("개인정보 미취급");

    private String value;

    PrivacyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
