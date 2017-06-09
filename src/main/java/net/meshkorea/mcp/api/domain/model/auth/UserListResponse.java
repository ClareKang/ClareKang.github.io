package net.meshkorea.mcp.api.domain.model.auth;

import net.meshkorea.mcp.api.domain.entity.auth.User;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import org.springframework.data.domain.Page;

/**
 * Created by reverof on 2017. 6. 9..
 */
public class UserListResponse extends BaseResponse {
    Page<User> data;
}
