package net.meshkorea.mcp.domain.model.common;

/**
 * Created by reverof on 2017. 6. 1..
 */
public abstract class BaseResponse {

    private final boolean success;
    private final ErrorDto error;

    /**
     * For Success Response with no return data
     */
    protected BaseResponse() {
        this.success = true;
        this.error = null;
    }

    /**
     * For Failure Response
     */
    public BaseResponse(ErrorDto error) {
        this.success = false;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public ErrorDto getError() {
        return error;
    }

}
