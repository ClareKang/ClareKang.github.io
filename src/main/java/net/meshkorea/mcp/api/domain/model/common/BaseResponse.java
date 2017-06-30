package net.meshkorea.mcp.api.domain.model.common;

/**
 * Created by reverof on 2017. 6. 1..
 */
public abstract class BaseResponse {

    private ResponseStatus status;
    private IntraErrorDto error;

    protected BaseResponse() {
        this.status = ResponseStatus.SUCCESS;
        this.error = null;
    }

    protected BaseResponse(IntraErrorDto error) {
        this.status = ResponseStatus.ERROR;
        this.error = error;
    }

    public boolean isSuccess() {
        return ResponseStatus.SUCCESS == this.status;
    }

    public ResponseStatus getStatus() {
        return this.status;
    }

    public IntraErrorDto getError() {
        return this.error;
    }

}
