package ec.gob.registrocivil.gateway.share.infrastructure.dto;

import org.springframework.http.HttpStatus;

public class ValidatePermissionResponse {

    private String message;

    private HttpStatus status;

    public ValidatePermissionResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
