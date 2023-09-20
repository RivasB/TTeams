package ec.gob.registrocivil.gateway.share.infrastructure.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources;
import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import ec.gob.registrocivil.gateway.share.infrastructure.dto.ExceptionResponse;

public class JsonErrorWebExceptionHandler extends DefaultErrorWebExceptionHandler {

    private final String INTERNAL_SERVER_ERROR_MESSAGE = "Internal Server Error";

    /**
     * Create a new {@code DefaultErrorWebExceptionHandler} instance.
     *
     * @param errorAttributes    the error attributes
     * @param resources          the resources configuration properties
     * @param errorProperties    the error configuration properties
     * @param applicationContext the current application context
     */
    public JsonErrorWebExceptionHandler(ErrorAttributes errorAttributes, Resources resources,
            ErrorProperties errorProperties, ApplicationContext applicationContext) {
        super(errorAttributes, resources, errorProperties, applicationContext);
    }

    /**
     * Extract the error attributes from the current request, to be used to populate
     * error
     * views or JSON payloads.
     *
     * @param request the source request
     * @param options options to control error attributes
     * @return the error attributes as a Map
     */
    @Override
    protected Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        // Here the logic can actually be customized according to the exception type
        Throwable error = super.getError(request);

        Map<String, Object> errorAttributes = new HashMap<>(5);

        String timestamp = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss '['z']'")
                .format(ZonedDateTime.now(ZoneId.of("UTC")));

        errorAttributes.put("timestamp", timestamp);

        if (error instanceof ExceptionResponse subEx) {
            errorAttributes.put("status", subEx.getStatus());
            errorAttributes.put("message", subEx.getMessage());
            errorAttributes.put("errors", subEx.getErrors());
            errorAttributes.put("data", subEx.getData());
        } else {
            Map<String, Object> originalErrorAttributes = super.getErrorAttributes(request, options);

            errorAttributes.put("status", originalErrorAttributes.get("status"));
            errorAttributes.put("message", originalErrorAttributes.get("message"));
            errorAttributes.put("errors", error.getMessage());
            errorAttributes.put("data", null);
        }

        return errorAttributes;
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }

    /**
     * Get the HTTP error status information from the error.
     *
     * @param errorAttributes the current error information
     * @return the error HTTP status
     */
    @Override
    protected int getHttpStatus(Map<String, Object> errorAttributes) {
        // Customize the HTTP response code based on the attributes inside the
        // errorAttributes
        if (errorAttributes.containsKey("status"))
            return (int) errorAttributes.get("status");

        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
}
