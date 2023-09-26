package cloud.tteams.identity.access.infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.access.domain.Station;
import cloud.tteams.identity.access.domain.event.StationCreatedEvent;
import cloud.tteams.identity.access.domain.event.StationDeletedEvent;
import cloud.tteams.identity.access.domain.event.StationUpdatedEvent;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.service.IEventService;

@Component
public class AccessEventService implements IEventService<Station> {
    private final KafkaTemplate<String, Event<?>> producer;

    public AccessEventService(KafkaTemplate<String, Event<?>> producer) {
        this.producer = producer;
    }

    @Value("${topic.user.name:access}")
    private String topic;

    @Override
    public void create(Station access) {
        StationCreatedEvent create = new StationCreatedEvent(access);
        this.producer.send(topic, create);
    }

    @Override
    public void update(Station access) {
        StationUpdatedEvent update = new StationUpdatedEvent(access);
        this.producer.send(topic, update);
    }

    @Override
    public void delete(Station access) {
        StationDeletedEvent delete = new StationDeletedEvent(access);
        this.producer.send(topic, delete);
    }
}
