package cloud.tteams.comment.comment.infrastructure.service;

import cloud.tteams.share.config.context.UserContext;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;
import cloud.tteams.share.core.domain.event.message.notification.NotificationPriority;
import cloud.tteams.share.core.domain.event.message.notification.NotificationStatus;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.comment.comment.domain.Comment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.event.Event;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class CommentEventServiceImplementation implements IEventService<Comment> {

    public static final String TASK_KEY = "task";
    public static final String RECIPIENT_KEY = "recipient";
    private final KafkaTemplate<String, Event> producer;

    private static final Log log = LogFactory.getLog(CommentEventServiceImplementation.class);

    public CommentEventServiceImplementation(KafkaTemplate<String, Event> producer) {
        this.producer = producer;
    }

    @Value("${topic.notification.name:notification}")
    private String topic;


    @Override
    public void publish(EventType type, Comment entity) {
        try {
            NotificationMessage notificationMessage = getNotificationMessage(type, entity).get();
            Event event = new Event(type, notificationMessage);
            this.producer.send(topic, event);
            log.info("A new "+ type.name() +" notification has been sent successfully");
        }
        catch (Exception e){
            log.info("An error occurred while sending a notification message with message: " + e.getMessage());
        }
    }

    @Override
    public CompletableFuture<NotificationMessage> getNotificationMessage(EventType type, Comment entity) {
        String stringNotificationMessage = "";
        switch(type) {
            case CREATED:
                stringNotificationMessage = String.format("The user %s add a new comment on your task: ", entity.getAuthor());
                break;
            case UPDATED:
                stringNotificationMessage = String.format("The user %s update his comment on your task: ", entity.getAuthor());
                break;
            default:
                // do nothing
        }
        Map<String, String> recipientAndTaskName = getRecipientAndTaskName(entity.getTask());
        String taskName = recipientAndTaskName.get(TASK_KEY);
        String recipient = recipientAndTaskName.get(RECIPIENT_KEY);
        NotificationMessage notificationMessage = new NotificationMessage(
                UUID.randomUUID(),
                entity.getTask(),
                UUID.fromString(recipient),
                "comment",
                stringNotificationMessage.concat(taskName),
                LocalDateTime.now(),
                NotificationPriority.MEDIUM,
                NotificationStatus.UNREAD
        );
        return CompletableFuture.completedFuture(notificationMessage);
    }

    private Map<String, String> getRecipientAndTaskName(UUID task) {
        //TODO: Agregar la busqueda por cache en en servicio de task
        return Map.of(TASK_KEY, task.toString(), RECIPIENT_KEY, UserContext.getUserSession().getUserId().toString());
    }
}
