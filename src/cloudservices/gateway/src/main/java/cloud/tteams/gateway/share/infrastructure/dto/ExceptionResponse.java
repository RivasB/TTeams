package cloud.tteams.gateway.share.infrastructure.dto;

import java.util.List;

public class ExceptionResponse extends RuntimeException {
    private String timestamp;

    private int status;

    private String message;

    private List<String> errors;

    private List<Object> data;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String timestamp, int status, String message, List<String> errors, List<Object> data) {
        super(message);
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public List<Object> getData() {
        return data;
    }
}
