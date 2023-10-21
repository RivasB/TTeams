package cloud.tteams.share.core.infrastructure.exceptions;

import cloud.tteams.share.core.domain.exception.BusinessException;
import cloud.tteams.share.core.domain.exception.BusinessRuleValidationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {

        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(
                ZonedDateTime.now(ZoneId.of("UTC")),
                HttpStatus.NOT_FOUND.value(),
                "Resource Not Found",
                details);

        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {

        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(
                ZonedDateTime.now(ZoneId.of("UTC")),
                HttpStatus.BAD_REQUEST,
                "Type Mismatch",
                details);

        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {

        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(
                ZonedDateTime.now(ZoneId.of("UTC")),
                HttpStatus.BAD_REQUEST,
                "Constraint Violations",
                details);

        return ResponseEntityBuilder.build(err);
    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(
                ZonedDateTime.now(ZoneId.of("UTC")),
                HttpStatus.BAD_REQUEST,
                "Malformed JSON request",
                details);

        return ResponseEntityBuilder.build(err);
    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<String> details = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + " : " + error.getDefaultMessage())
                .toList();

        ApiError err = new ApiError(
                ZonedDateTime.now(ZoneId.of("UTC")),
                HttpStatus.BAD_REQUEST,
                "Validation Errors",
                details);

        return ResponseEntityBuilder.build(err);
    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<String> details = new ArrayList<>();
        details.add(ex.getParameterName() + " parameter is missing");

        ApiError err = new ApiError(
                ZonedDateTime.now(ZoneId.of("UTC")),
                HttpStatus.BAD_REQUEST,
                "Missing Parameters",
                details);

        return ResponseEntityBuilder.build(err);
    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
                                                                     HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<String> details = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        StringJoiner joiner = new StringJoiner(", ");

        builder.append(ex.getContentType());
        builder.append(" media type is not supported. Supported media types are ");
        ex.getSupportedMediaTypes().forEach(t -> joiner.add(t.toString()));
        builder.append(joiner);

        details.add(builder.toString());

        ApiError err = new ApiError(
                ZonedDateTime.now(ZoneId.of("UTC")),
                HttpStatus.UNSUPPORTED_MEDIA_TYPE,
                "Unsupported Media Type",
                details);

        return ResponseEntityBuilder.build(err);
    }

    @Override
    @Nullable
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
                                                                   HttpStatusCode status, WebRequest request) {

        List<String> details = new ArrayList<>();
        details.add(String.format("Could not find the %s method for URL %s", ex.getHttpMethod(),
                ex.getRequestURL()));

        ApiError err = new ApiError(
                ZonedDateTime.now(ZoneId.of("UTC")),
                HttpStatus.NOT_FOUND,
                "Method Not Found",
                details);

        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(BusinessRuleValidationException.class)
    public ResponseEntity<Object> handleBusinessRuleValidationException(BusinessRuleValidationException ex) {

        List<String> details = Collections.singletonList(ex.getDetails());

        ApiError err = new ApiError(
                ZonedDateTime.now(ZoneId.of("UTC")),
                ex.getStatus(),
                ex.getMessage(),
                details);

        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException ex) {
        List<String> details = Collections.singletonList(ex.getMessage());
        ApiError err = new ApiError(
                ZonedDateTime.now(ZoneId.of("UTC")),
                HttpStatus.UNAUTHORIZED,
                "Unauthorized error",
                details);
        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException ex) {

        List<String> details = new ArrayList<>();
        details.add(ex.getDetails());

        ApiError err = new ApiError(
                ZonedDateTime.now(ZoneId.of("UTC")),
                ex.getStatus(),
                ex.getMessage(),
                details);

        return ResponseEntityBuilder.build(err);
    }

    // Deal with ALL Other Exceptions
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {

        List<String> details = Collections.singletonList(ex.getLocalizedMessage());

        ApiError err = new ApiError(
                ZonedDateTime.now(ZoneId.of("UTC")),
                HttpStatus.BAD_REQUEST,
                "Error occurred",
                details);

        return ResponseEntityBuilder.build(err);
    }
}
