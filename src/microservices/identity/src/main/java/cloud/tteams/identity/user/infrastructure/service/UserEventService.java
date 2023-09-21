package cloud.tteams.identity.user.infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.identity.user.domain.User;
import cloud.tteams.identity.user.domain.event.UserCreatedEvent;
import cloud.tteams.identity.user.domain.event.UserDeletedEvent;
import cloud.tteams.identity.user.domain.event.UserUpdatedEvent;

@Component
public class UserEventService implements IEventService<User> {
    private final KafkaTemplate<String, Event<?>> producer;

    public UserEventService(KafkaTemplate<String, Event<?>> producer) {
        this.producer = producer;
    }

    @Value("${topic.user.name:users}")
    private String topic;

    @Override
    public void create(User user) {
        UserCreatedEvent create = new UserCreatedEvent(user);
        this.producer.send(topic, create);
    }

    @Override
    public void update(User user) {
        UserUpdatedEvent update = new UserUpdatedEvent(user);
        this.producer.send(topic, update);
    }

    @Override
    public void delete(User user) {
        UserDeletedEvent delete = new UserDeletedEvent(user);
        this.producer.send(topic, delete);
    }
}
