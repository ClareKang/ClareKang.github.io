package net.meshkorea.mcp.api.domain.model.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import mybatis.IntraErrorDto;

/**
 * Created by reverof on 2017. 6. 20..
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GroupResponse extends BaseResponse {

    private GroupDto data;

    public GroupResponse(IntraErrorDto error) {
        super(error);
    }
}
