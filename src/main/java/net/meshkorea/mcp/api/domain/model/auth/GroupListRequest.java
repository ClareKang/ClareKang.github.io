package net.meshkorea.mcp.api.domain.model.auth;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseRequest;
import net.meshkorea.mcp.api.domain.model.common.PageableRequest;

/**
 * Created by reverof on 2017-06-06.
 */
@Getter
@Setter
public class GroupListRequest extends BaseRequest implements PageableRequest {

    private String hasPrivacy;

    private String searchType;

    private String searchText;

    private Integer page;

    private Integer size;

    public Boolean hasPrivacy() {
        return PrivacyEnum.Y.name().equals(hasPrivacy);
    }

}
