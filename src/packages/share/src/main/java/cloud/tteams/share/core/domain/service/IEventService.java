package cloud.tteams.share.core.domain.service;

import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

@Async
public interface IEventService<T> {
    void publish(EventType type, T entity);
    CompletableFuture<NotificationMessage> getNotificationMessage(EventType type, T entity);
}
