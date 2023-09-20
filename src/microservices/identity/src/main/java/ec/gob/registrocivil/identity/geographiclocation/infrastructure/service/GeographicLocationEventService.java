package ec.gob.registrocivil.identity.geographiclocation.infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.identity.geographiclocation.domain.event.GeographicLocationCreatedEvent;
import ec.gob.registrocivil.identity.geographiclocation.domain.event.GeographicLocationDeletedEvent;
import ec.gob.registrocivil.identity.geographiclocation.domain.event.GeographicLocationUpdatedEvent;
import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.service.IEventService;

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
