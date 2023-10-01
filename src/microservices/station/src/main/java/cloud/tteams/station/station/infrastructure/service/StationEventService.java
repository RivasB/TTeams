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

    @Value("${topic.station.name:station}")
    private String topic;

    @Override
    public void create(Station station) {
        StationCreatedEvent create = new StationCreatedEvent(station);
        this.producer.send(topic, create);
    }

    @Override
    public void update(Station station) {
        StationUpdatedEvent update = new StationUpdatedEvent(station);
        this.producer.send(topic, update);
    }

    @Override
    public void delete(Station station) {
        StationDeletedEvent delete = new StationDeletedEvent(station);
        this.producer.send(topic, delete);
    }
}
