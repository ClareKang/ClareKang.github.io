package net.meshkorea.mcp.api.error.exception;

import net.meshkorea.mcp.api.domain.model.common.IntraErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class CustomBindingException extends Exception {

    private static final long serialVersionUID = -4409954855381406454L;
    private static final Logger logger = LoggerFactory.getLogger(CustomBindingException.class);

    private ErrorResponse errorResponse;

    public CustomBindingException(BindingResult bindingResult) {
        FieldError fieldError = bindingResult.getFieldError();

        IntraErrorDto paramError = new IntraErrorDto(HttpStatus.BAD_REQUEST, fieldError.getDefaultMessage());
        this.errorResponse = new ErrorResponse(paramError);
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }
}
