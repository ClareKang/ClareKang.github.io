package net.meshkorea.mcp.api.domain.model.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseRequest;
import net.meshkorea.mcp.api.domain.model.common.PageableRequest;

/**
 * Created by reverof on 2017-06-06.
 */
@NoArgsConstructor
@AllArgsConstructor
public class GroupListRequest extends BaseRequest implements PageableRequest {

    @Getter
    @Setter
    private String hasPrivacy;

    @Getter
    @Setter
    private String searchType;

    @Getter
    @Setter
    private String searchText;

    @Getter
    @Setter
    private Integer page;

    @Getter
    @Setter
    private Integer size;

    public Boolean hasPrivacy() {
        return PrivacyEnum.Y.name().equals(hasPrivacy);
    }

}
