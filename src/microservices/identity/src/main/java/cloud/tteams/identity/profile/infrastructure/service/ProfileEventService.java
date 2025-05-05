package cloud.tteams.identity.profile.infrastructure.service;

import cloud.tteams.identity.organization.infrastructure.service.OrganizationEventServiceImplementation;
import cloud.tteams.share.config.context.UserContext;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;
import cloud.tteams.share.core.domain.event.message.notification.NotificationPriority;
import cloud.tteams.share.core.domain.event.message.notification.NotificationStatus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.event.ProfileCreatedEvent;
import cloud.tteams.identity.profile.domain.event.ProfileUpdatedEvent;
import cloud.tteams.identity.profile.domain.event.ProfileDeletedEvent;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.service.IEventService;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ProfileEventService implements IEventService<Profile> {

    private final KafkaTemplate<String, Event> producer;
    private static final Log log = LogFactory.getLog(ProfileEventService.class);

    public ProfileEventService(KafkaTemplate<String, Event> producer) {
        this.producer = producer;
    }

    @Value("${topic.notification.name:notification}")
    private String topic;


    @Override
    public void publish(EventType type, Profile entity) {
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
    public CompletableFuture<NotificationMessage> getNotificationMessage(EventType type, Profile entity) {
        String stringNotificationMessage = "";
        switch(type) {
            case CREATED:
                stringNotificationMessage = String.format("Your Profile %s has been created successfully", entity.getName());
                break;
            case UPDATED:
                stringNotificationMessage = String.format("The Profile named %s has been updated successfully", entity.getName());
                break;
            case DELETED:
                stringNotificationMessage = String.format("The Profile named %s has been deleted successfully", entity.getName());
                break;
            default:
                // do nothing
        }
        NotificationMessage notificationMessage = new NotificationMessage(
                UUID.randomUUID(),
                entity.getId(),
                UserContext.getUserSession().getUserId(),
                "identity",
                stringNotificationMessage,
                LocalDateTime.now(),
                NotificationPriority.LOW,
                NotificationStatus.NEW
        );
        return CompletableFuture.completedFuture(notificationMessage);
    }
}
