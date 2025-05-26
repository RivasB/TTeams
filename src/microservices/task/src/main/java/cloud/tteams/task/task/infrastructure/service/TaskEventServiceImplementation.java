package cloud.tteams.task.task.infrastructure.service;

import cloud.tteams.share.config.context.UserContext;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;
import cloud.tteams.share.core.domain.event.message.notification.NotificationPriority;
import cloud.tteams.share.core.domain.event.message.notification.NotificationStatus;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.task.task.domain.Task;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Component
public class TaskEventServiceImplementation implements IEventService<Task> {


    private final KafkaTemplate<String, Event> producer;

    public TaskEventServiceImplementation(KafkaTemplate<String, Event> producer) {
        this.producer = producer;
    }

    private static final Log log = LogFactory.getLog(TaskEventServiceImplementation.class);

    @Value("${topic.notification.name:notification}")
    private String topic;

    @Override
    public void publish(EventType type, Task task){
        try {
            List<NotificationMessage> notificationMessageList = getListOfNotificationMessage(type, task).get();
            notificationMessageList.forEach(notificationMessage -> {
                Event event = new Event(type, notificationMessage);
                this.producer.send(topic, event);
                log.info("A new "+ type.name() +" notification has been sent successfully");
            });
        }
        catch (Exception e){
            log.info("An error occurred while sending a notification message with message: " + e.getMessage());
        }
    }

    @Override
    public CompletableFuture<NotificationMessage> getNotificationMessage(EventType type, Task task) {
        String stringNotificationMessage = "";
        switch(type) {
            case CREATED:
                stringNotificationMessage = String.format("The Task %s has been created successfully", task.getName());
                break;
            case UPDATED:
                stringNotificationMessage = String.format("The Task %s has been updated", task.getName());
                break;
            case DELETED:
                stringNotificationMessage = String.format("The Task %s has been deleted", task.getName());
                break;
            default:
                // do nothing
        }
        NotificationMessage notificationMessage = new NotificationMessage(
                UUID.randomUUID(),
                task.getId().getValue(),
                task.getReportingUser().value(),
                "task",
                stringNotificationMessage,
                LocalDateTime.now(),
                NotificationPriority.HIGH,
                NotificationStatus.UNREAD
        );
        return CompletableFuture.completedFuture(notificationMessage);
    }

    private CompletableFuture<List<NotificationMessage>> getListOfNotificationMessage(EventType type, Task task) {
        List<NotificationMessage> notificationMessageList = new ArrayList<>();
        String contextUsername = UserContext.getUserSession().getUsername();
        notificationMessageList.add(getNotificationMessage(type, task).join());
        String stringNotificationMessage = "";
        if (task.getAssignedUser() != null) {
            switch(type) {
                case CREATED, ASSIGNED:
                    stringNotificationMessage = String.format("You have been assigned to the Task %s", task.getName());
                    break;
                case UPDATED:
                    stringNotificationMessage = String.format("Your Task %s has been updated by %s", task.getName(), contextUsername);
                    break;
                case DELETED:
                    stringNotificationMessage = String.format("Your Task %s has been deleted by %s", task.getName(), contextUsername);
                    break;
                default:
                    // do nothing
            }
            NotificationMessage assignedUserNotification = new NotificationMessage(
                    UUID.randomUUID(),
                    task.getId().getValue(),
                    task.getAssignedUser().value(),
                    "task",
                    stringNotificationMessage,
                    LocalDateTime.now(),
                    NotificationPriority.HIGH,
                    NotificationStatus.UNREAD
            );
            notificationMessageList.add(assignedUserNotification);
        }
        return CompletableFuture.completedFuture(notificationMessageList);
    }
}
