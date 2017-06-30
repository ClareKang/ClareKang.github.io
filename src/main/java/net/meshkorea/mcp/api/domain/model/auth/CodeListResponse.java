package net.meshkorea.mcp.api.domain.model.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.CodesDto;
import mybatis.IntraErrorDto;

import java.util.List;

/**
 * Created by reverof on 2017. 6. 14..
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CodeListResponse extends BaseResponse {

    List<CodesDto> data;

    public CodeListResponse(IntraErrorDto error) {
        super(error);
    }
}
