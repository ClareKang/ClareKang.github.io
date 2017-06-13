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
public class UserListRequest extends BaseRequest implements PageableRequest {
    private String userId;
    private String userName;
    private String userType;
    private Long groupId;
    private String groupName;
    private Integer page;
    private Integer size;
}
