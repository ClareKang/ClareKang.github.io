package net.meshkorea.mcp.api.error;

import net.meshkorea.mcp.api.error.exception.CustomBindingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHandlerController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity handlerException(Exception exception, HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (exception instanceof CustomBindingException) {
            CustomBindingException e = (CustomBindingException) exception;
            return new ResponseEntity(e.getErrorResponse(), HttpStatus.BAD_REQUEST);
        }

        throw exception;
    }

}
