package net.meshkorea.mcp.api.domain.model.auth;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by reverof on 2017. 6. 11..
 */
@Getter
@Setter
public class AuthorityDto extends SiteCodeDto {

    private Long authorityNo;

    private String authorityName;

    private String authorityCode;

    private String hasPrivacy;

    private String viewName;

    private String viewUri;

    private String resourceName;

    private String resourceUri;

}
