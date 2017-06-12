package net.meshkorea.mcp.api.domain.model.common;

/**
 * Created by reverof on 2017. 6. 1..
 */
public abstract class BaseResponse {

    private ResponseStatus status;
    private ErrorDto error;

    protected BaseResponse() {
        this.status = ResponseStatus.SUCCESS;
        this.error = null;
    }

    public BaseResponse(ErrorDto error) {
        this.status = ResponseStatus.ERROR;
        this.error = error;
    }

    public boolean isSuccess() {
        return ResponseStatus.SUCCESS == this.status;
    }

    public ErrorDto getError() {
        return error;
    }

}
