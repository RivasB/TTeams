package cloud.tteams.log.log.application.query;

import cloud.tteams.log.log.domain.Log;
import cloud.tteams.share.core.domain.bus.query.IResponse;
import cloud.tteams.share.core.domain.event.message.log.LogType;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class LogResponse implements IResponse {
    private UUID id;
    private LogType type;
    private String message;
    private String serviceName;
    private String methodName;
    private String user;
    private String userRole;
    private LocalDateTime timestamp;
    private Map<String, Object> additionalData;

    public LogResponse() {
    }

    public LogResponse(Log log) {
        this.id = log.getId().value();
        this.type = log.getType();
        this.message = log.getMessage().value();
        this.serviceName = log.getServiceName().value();
        this.methodName = log.getMethodName().value();
        this.user = log.getUser().value();
        this.userRole = log.getUserRole().value();
        this.timestamp = log.getTimestamp().value();
        this.additionalData = log.getAdditionalData().value();
    }

    public UUID getId() {
        return id;
    }

    public LogType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getUser() {
        return user;
    }

    public String getUserRole() {
        return userRole;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Map<String, Object> getAdditionalData() {
        return additionalData;
    }
}
