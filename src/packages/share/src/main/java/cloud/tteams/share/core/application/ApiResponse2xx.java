package cloud.tteams.share.core.application;

import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ApiResponse2xx<T> {

    private final String timestamp;

    private final int status;

    private final String message;

    private final String errors;

    private final T data;

    public ApiResponse2xx(T data, HttpStatus status) {
        this.timestamp = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss '['z']'")
                .format(ZonedDateTime.now(ZoneId.of("UTC")));
        this.status = status.value();
        this.message = "OK";
        this.errors = null;
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

    public String getErrors() {
        return errors;
    }

    public T getData() {
        return data;
    }

}
