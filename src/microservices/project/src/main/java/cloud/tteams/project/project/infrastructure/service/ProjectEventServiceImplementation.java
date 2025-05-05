package cloud.tteams.project.project.infrastructure.service;

import cloud.tteams.share.config.context.UserContext;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;
import cloud.tteams.share.core.domain.event.message.notification.NotificationPriority;
import cloud.tteams.share.core.domain.event.message.notification.NotificationStatus;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.project.project.domain.Project;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.event.Event;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class ProjectEventServiceImplementation implements IEventService<Project> {

    private final KafkaTemplate<String, Event> producer;

    public ProjectEventServiceImplementation(KafkaTemplate<String, Event> producer) {
        this.producer = producer;
    }

    private static final Log log = LogFactory.getLog(ProjectEventServiceImplementation.class);

    @Value("${topic.notification.name:notification}")
    private String topic;

    @Override
    public void publish(EventType type, Project project){
        try {
            NotificationMessage notificationMessage = getNotificationMessage(type, project).get();
            Event event = new Event(type, notificationMessage);
            this.producer.send(topic, event);
            log.info("A new "+ type.name() +" notification has been sent successfully");
        }
        catch (Exception e){
            log.info("An error occurred while sending a notification message with message: " + e.getMessage());
        }
    }

    @Override
    public CompletableFuture<NotificationMessage> getNotificationMessage(EventType type, Project project) {
        String stringNotificationMessage = "";
        switch(type) {
            case CREATED:
                stringNotificationMessage = String.format("Your Project %s has been created successfully", project.getName());
                break;
            case UPDATED:
                stringNotificationMessage = String.format("The Project named %s has been updated successfully", project.getName());
                break;
            case DELETED:
                stringNotificationMessage = String.format("The Project named %s has been deleted successfully", project.getName());
                break;
            default:
                // do nothing
        }
        NotificationMessage notificationMessage = new NotificationMessage(
                UUID.randomUUID(),
                project.getId().getValue(),
                UserContext.getUserSession().getUserId(),
                "project",
                stringNotificationMessage,
                LocalDateTime.now(),
                NotificationPriority.LOW,
                NotificationStatus.UNREAD
        );
        return CompletableFuture.completedFuture(notificationMessage);
    }
}
