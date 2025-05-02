package cloud.tteams.log.log.infrastructure.repository.document;

import cloud.tteams.log.log.domain.Log;
import cloud.tteams.log.log.domain.valueobject.*;
import cloud.tteams.share.core.domain.event.message.log.LogType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Document(collection = "logs")
public class LogDocument {

    @Id
    private UUID id;

    @Field("type")
    private String type;

    @Field("message")
    private String message;

    @Field("serviceName")
    private String serviceName;

    @Field("methodName")
    private String methodName;

    @Field("user")
    private String user;

    @Field("userRole")
    private String userRole;

    @Field("timestamp")
    private LocalDateTime timestamp;

    @Field("additionalData")
    private Map<String, Object> additionalData;

    public LogDocument() {
    }

    public LogDocument(Log log) {
        this.id = log.getId().getValue();
        this.type = log.getType().name();
        this.message = log.getMessage().getValue();
        this.serviceName = log.getServiceName().getValue();
        this.methodName = log.getMethodName().getValue();
        this.user = log.getUser().getValue();
        this.userRole = log.getUserRole().getValue();
        this.timestamp = log.getTimestamp().getValue();
        this.additionalData = log.getAdditionalData().value();
    }

    public Log toAggregate() {
        return new Log(
            new LogId(this.id),
            LogType.valueOf(this.type),
            new LogMessage(this.message),
            new LogServiceName(this.serviceName),
            new LogMethodName(this.methodName),
            new LogUser(this.user),
            new LogUserRole(this.userRole),
            new LogTimeStamp(this.timestamp),
            new LogAdditionalData(this.additionalData)
        );
    }
}