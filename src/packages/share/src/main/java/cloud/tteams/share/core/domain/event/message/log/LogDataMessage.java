package cloud.tteams.share.core.domain.event.message.log;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;


public class LogDataMessage {
    private final UUID id;
    private final LogType type;
    private final String message;
    private final String serviceName;
    private final String methodName;
    private final String user;
    private final String userRole;
    private final LocalDateTime timestamp;
    private final Map<String, Object> additionalData;

    public LogDataMessage(UUID id, LogType type, String message, String serviceName, String methodName, String user, String userRole, LocalDateTime timestamp, Map<String, Object> additionalData) {
        this.id = id;
        this.type = type;
        this.message = message;
        this.serviceName = serviceName;
        this.methodName = methodName;
        this.user = user;
        this.userRole = userRole;
        this.timestamp = timestamp;
        this.additionalData = additionalData;
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
