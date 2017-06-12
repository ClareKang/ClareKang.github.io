package net.meshkorea.mcp.api.domain.model.auth;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.meshkorea.mcp.api.domain.entity.auth.User;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.ErrorDto;

import java.util.List;

/**
 * Created by reverof on 2017. 6. 9..
 */
@NoArgsConstructor
@AllArgsConstructor
public class UserListResponse extends BaseResponse {

    public UserListResponse(ErrorDto errorDto) {
        super(errorDto);
    }

    List<User> data = null;
}
