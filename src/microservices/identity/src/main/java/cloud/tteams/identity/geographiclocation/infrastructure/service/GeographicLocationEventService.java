package cloud.tteams.identity.geographiclocation.infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.identity.geographiclocation.domain.event.GeographicLocationCreatedEvent;
import cloud.tteams.identity.geographiclocation.domain.event.GeographicLocationDeletedEvent;
import cloud.tteams.identity.geographiclocation.domain.event.GeographicLocationUpdatedEvent;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.service.IEventService;

@Service
public class GeographicLocationEventService implements IEventService<GeographicLocation> {

    private final KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.user.name:location}")
    private String topic;

    public GeographicLocationEventService(KafkaTemplate<String, Event<?>> producer) {
        this.producer = producer;
    }

    @Override
    public void create(GeographicLocation entity) {
        GeographicLocationCreatedEvent event = new GeographicLocationCreatedEvent(entity);
        this.producer.send(topic, event);
    }

    @Override
    public void update(GeographicLocation entity) {
        GeographicLocationUpdatedEvent event = new GeographicLocationUpdatedEvent(entity);
        this.producer.send(topic, event);
    }

    @Override
    public void delete(GeographicLocation entity) {
        GeographicLocationDeletedEvent event = new GeographicLocationDeletedEvent(entity);
        this.producer.send(topic, event);
    }

}
