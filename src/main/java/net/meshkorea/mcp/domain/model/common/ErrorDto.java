package net.meshkorea.mcp.domain.model.common;

import org.springframework.http.HttpStatus;

/**
 * Created by reverof on 2017. 6. 1..
 */
public class ErrorDto {

    private final HttpStatus code;
    private final String message;
    private final String displayMessage;

    public ErrorDto(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
        this.displayMessage = null;
    }

    public ErrorDto(HttpStatus code, String message, String displayMessage) {
        this.code = code;
        this.message = message;
        this.displayMessage = displayMessage;
    }

    public HttpStatus getErrorCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

}
