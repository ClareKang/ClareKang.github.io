package net.meshkorea.mcp.api.domain.model.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.ErrorDto;

/**
 * Created by reverof on 2017-06-13.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponse extends BaseResponse {

    public UserResponse(ErrorDto errorDto) {
        super(errorDto);
    }

    UserDto data;
}
