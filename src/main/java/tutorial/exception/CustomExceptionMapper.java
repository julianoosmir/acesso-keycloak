package tutorial.exception;


import io.vertx.core.http.HttpServerRequest;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public abstract class CustomExceptionMapper<T extends Throwable> implements ExceptionMapper<T> {

    @Context
    protected HttpServerRequest request;

    protected ErrorResponse getErrorResponse(T exception) {
        String errorId = UUID.randomUUID().toString();

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorId(errorId);
        errorResponse.setType(request.absoluteURI());
        errorResponse.setInstance(request.path());
        errorResponse.setDetail(exception.getMessage());
        errorResponse.setMethod(request.method().toString());
        errorResponse.setInvalidParams(null);

        logErrorWithoutStackTrace(errorId, exception.getMessage());
        return errorResponse;
    }

    private void logErrorWithoutStackTrace(String errorId, String errorMessage) {
        log.error("errorId[{}]: {}", errorId, errorMessage);
    }

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(T e) {
        ErrorResponse errorResponse = this.getErrorResponse(e);
        errorResponse.setTitle("");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorResponse).build();
    }
}