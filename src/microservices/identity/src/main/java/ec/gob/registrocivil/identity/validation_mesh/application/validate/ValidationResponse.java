package ec.gob.registrocivil.identity.validation_mesh.application.validate;

import org.springframework.http.HttpStatus;

public class ValidationResponse {

    private HttpStatus status;

    private String message;

    public ValidationResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
