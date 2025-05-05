package cloud.tteams.notification.notification.infrastructure.service;

import cloud.tteams.notification.notification.domain.Notification;
import cloud.tteams.notification.notification.domain.service.INotificationDomainService;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumerService {

    private final INotificationDomainService domainService;

    public NotificationConsumerService(INotificationDomainService domainService) {
        this.domainService = domainService;
    }

    @KafkaListener(topics = "notification", groupId = "notification-subscriber-group")
    public void consumeNotificationEvent(ConsumerRecord<String, Event> record) {
        try {
            Event event = record.value();
            NotificationMessage notificationData = (NotificationMessage) event.getData();
            Notification notification = new Notification(notificationData);
            domainService.create(notification);
        } catch (Exception e) {
            System.err.println("Error processing notification event: " + e.getMessage());
        }
    }
}
