package net.meshkorea.mcp.api.domain.model.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import mybatis.IntraErrorDto;

/**
 * Created by reverof on 2017-06-13.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponse extends BaseResponse {

    UserDto data;

    public UserResponse(IntraErrorDto intraErrorDto) {
        super(intraErrorDto);
    }

}
