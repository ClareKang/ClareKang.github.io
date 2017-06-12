package net.meshkorea.mcp.api.domain.model.common;

import org.springframework.http.HttpStatus;

/**
 * Created by reverof on 2017. 6. 1..
 */
public class ErrorDto {

    private final HttpStatus code;
    private final String message;

    public ErrorDto(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

    public HttpStatus getErrorCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
