package cloud.tteams.log.log.application.query;

import cloud.tteams.log.log.domain.Log;
import cloud.tteams.share.core.domain.bus.query.IResponse;
import cloud.tteams.share.core.domain.event.message.log.LogType;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class LogResponse implements IResponse {
    private final UUID id;
    private final LogType type;
    private final String message;
    private final String serviceName;
    private final String methodName;
    private final String user;
    private final String userRole;
    private final LocalDateTime timestamp;
    private final Map<String, Object> additionalData;

    public LogResponse(Log log) {
        this.id = log.getId().getValue();
        this.type = log.getType();
        this.message = log.getMessage().getValue();
        this.serviceName = log.getServiceName().getValue();
        this.methodName = log.getMethodName().getValue();
        this.user = log.getUser().getValue();
        this.userRole = log.getUserRole().getValue();
        this.timestamp = log.getTimestamp().getValue();
        this.additionalData = log.getAdditionalData().value();
    }

    public UUID id() {
        return id;
    }

    public LogType type() {
        return type;
    }

    public String message() {
        return message;
    }

    public String serviceName() {
        return serviceName;
    }

    public String methodName() {
        return methodName;
    }

    public String user() {
        return user;
    }

    public String userRole() {
        return userRole;
    }

    public LocalDateTime timestamp() {
        return timestamp;
    }

    public Map<String, Object> additionalData() {
        return additionalData;
    }
}
