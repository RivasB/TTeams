package cloud.tteams.project.log.domain;

import cloud.tteams.project.log.domain.valueobject.*;
import cloud.tteams.share.core.domain.event.message.log.LogDataMessage;
import cloud.tteams.share.core.domain.event.message.log.LogType;

public class Log {

    private final LogId id;
    private final LogType type;
    private final LogMessage message;
    private final LogServiceName serviceName;
    private final LogMethodName methodName;
    private final LogUser user;
    private final LogUserRole userRole;
    private final LogTimeStamp timestamp;
    private final LogAdditionalData additionalData;

    public Log(LogId id, LogType type, LogMessage message, LogServiceName serviceName, LogMethodName methodName, LogUser user, LogUserRole userRole, LogTimeStamp timestamp, LogAdditionalData additionalData) {
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

    public Log(LogDataMessage message) {
        this.id = new LogId(message.getId());
        this.type = message.getType();
        this.message = new LogMessage(message.getMessage());
        this.serviceName = new LogServiceName(message.getServiceName());
        this.methodName = new LogMethodName(message.getMethodName());
        this.user = new LogUser(message.getUser());
        this.userRole = new LogUserRole(message.getUserRole());
        this.timestamp = new LogTimeStamp(message.getTimestamp());
        this.additionalData = new LogAdditionalData(message.getAdditionalData());
    }

    public LogId getId() {
        return id;
    }

    public LogType getType() {
        return type;
    }

    public LogMessage getMessage() {
        return message;
    }

    public LogServiceName getServiceName() {
        return serviceName;
    }

    public LogMethodName getMethodName() {
        return methodName;
    }

    public LogUser getUser() {
        return user;
    }

    public LogUserRole getUserRole() {
        return userRole;
    }

    public LogTimeStamp getTimestamp() {
        return timestamp;
    }

    public LogAdditionalData getAdditionalData() {
        return additionalData;
    }
}
