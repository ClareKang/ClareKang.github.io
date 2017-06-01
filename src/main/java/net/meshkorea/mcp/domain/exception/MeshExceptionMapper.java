package net.meshkorea.mcp.domain.exception;

import io.katharsis.errorhandling.ErrorData;
import io.katharsis.errorhandling.ErrorDataBuilder;
import io.katharsis.errorhandling.ErrorResponse;
import io.katharsis.errorhandling.mapper.ExceptionMapper;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 1..
 */
@Component
public class MeshExceptionMapper implements ExceptionMapper<MeshException> {
    private static final int CUSTOM_ERROR_STATUS_CODE = 599;

    @Override
    public ErrorResponse toErrorResponse(MeshException e) {
        ErrorDataBuilder builder = ErrorData.builder();
        builder.setStatus(String.valueOf(CUSTOM_ERROR_STATUS_CODE));
        builder.setTitle(e.getMessage());
        ErrorData error = builder.build();
        List<ErrorData> errors = Arrays.asList(error);
        return ErrorResponse.builder().setStatus(CUSTOM_ERROR_STATUS_CODE).setErrorData(errors).build();
    }

    @Override
    public MeshException fromErrorResponse(ErrorResponse errorResponse) {
        return new MeshException();
    }

    @Override
    public boolean accepts(ErrorResponse errorResponse) {
        return errorResponse.getHttpStatus() == CUSTOM_ERROR_STATUS_CODE;
    }

}
