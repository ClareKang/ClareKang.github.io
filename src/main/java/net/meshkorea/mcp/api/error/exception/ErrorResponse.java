package net.meshkorea.mcp.api.error.exception;

import lombok.Getter;
import lombok.Setter;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.IntraErrorDto;

@Getter
@Setter
public class ErrorResponse extends BaseResponse {

    public ErrorResponse(IntraErrorDto paramError) {
        super(paramError);
    }
}
