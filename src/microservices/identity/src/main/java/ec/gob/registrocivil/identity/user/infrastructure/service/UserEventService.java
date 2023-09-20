package ec.gob.registrocivil.identity.user.infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.service.IEventService;
import ec.gob.registrocivil.identity.user.domain.User;
import ec.gob.registrocivil.identity.user.domain.event.UserCreatedEvent;
import ec.gob.registrocivil.identity.user.domain.event.UserDeletedEvent;
import ec.gob.registrocivil.identity.user.domain.event.UserUpdatedEvent;

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
