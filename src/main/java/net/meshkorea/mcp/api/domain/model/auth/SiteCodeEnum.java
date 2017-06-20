package net.meshkorea.mcp.api.domain.model.auth;

/**
 * Created by reverof on 2017. 6. 19..
 */
public enum SiteCodeEnum {

    MCP("Mesh Control Platform");

    private String value;

    SiteCodeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
