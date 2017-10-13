package net.meshkorea.mcp.api.error.exception;

import lombok.Data;
import net.meshkorea.mcp.api.domain.model.common.BaseResponse;
import net.meshkorea.mcp.api.domain.model.common.IntraErrorDto;

@Data
public class ErrorResponse extends BaseResponse {

    public ErrorResponse(IntraErrorDto paramError) {
        super(paramError);
    }
}
