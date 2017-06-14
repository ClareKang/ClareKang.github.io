package net.meshkorea.mcp.api.domain.model.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.CodesDto;
import net.meshkorea.mcp.api.domain.model.common.ErrorDto;

import java.util.List;

/**
 * Created by reverof on 2017. 6. 14..
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserTypeListResponse extends BaseResponse {

    List<CodesDto> data;

    public UserTypeListResponse(ErrorDto error) {
        super(error);
    }
}
