package cloud.tteams.identity.authorization.infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.authorization.domain.Access;
import cloud.tteams.identity.authorization.domain.event.AccessCreatedEvent;
import cloud.tteams.identity.authorization.domain.event.AccessDeletedEvent;
import cloud.tteams.identity.authorization.domain.event.AccessUpdatedEvent;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.service.IEventService;

@Component
public class AccessEventService implements IEventService<Access> {
    private final KafkaTemplate<String, Event<?>> producer;

    public AccessEventService(KafkaTemplate<String, Event<?>> producer) {
        this.producer = producer;
    }

    @Value("${topic.user.name:authorization}")
    private String topic;

    @Override
    public void create(Access access) {
        AccessCreatedEvent create = new AccessCreatedEvent(access);
        this.producer.send(topic, create);
    }

    @Override
    public void update(Access access) {
        AccessUpdatedEvent update = new AccessUpdatedEvent(access);
        this.producer.send(topic, update);
    }

    @Override
    public void delete(Access access) {
        AccessDeletedEvent delete = new AccessDeletedEvent(access);
        this.producer.send(topic, delete);
    }
}
