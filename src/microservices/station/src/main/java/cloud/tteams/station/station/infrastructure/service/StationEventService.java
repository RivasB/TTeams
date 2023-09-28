package cloud.tteams.station.station.infrastructure.service;

import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.event.StationCreatedEvent;
import cloud.tteams.station.station.domain.event.StationDeletedEvent;
import cloud.tteams.station.station.domain.event.StationUpdatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.event.Event;

@Component
public class StationEventService implements IEventService<Station> {
    private final KafkaTemplate<String, Event<?>> producer;

    public StationEventService(KafkaTemplate<String, Event<?>> producer) {
        this.producer = producer;
    }

    @Value("${topic.user.name:station}")
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