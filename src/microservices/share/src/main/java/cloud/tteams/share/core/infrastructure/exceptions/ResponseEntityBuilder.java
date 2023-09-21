package cloud.tteams.share.core.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {

    public static ResponseEntity<Object> build(ApiError apiError) {
        // If status is greater than 600 then it is a custom status code and BAD_REQUEST
        // is returned
        int status = (apiError.getStatus() >= 600) ? HttpStatus.BAD_REQUEST.value() : apiError.getStatus();

        return new ResponseEntity<>(apiError, HttpStatus.valueOf(status));
    }

    private ResponseEntityBuilder() {
    }
}
