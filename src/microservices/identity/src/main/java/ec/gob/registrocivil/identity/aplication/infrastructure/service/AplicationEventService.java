package ec.gob.registrocivil.identity.aplication.infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.aplication.domain.Aplication;
import ec.gob.registrocivil.identity.aplication.domain.event.AplicationCreatedEvent;
import ec.gob.registrocivil.identity.aplication.domain.event.AplicationDeletedEvent;
import ec.gob.registrocivil.identity.aplication.domain.event.AplicationUpdatedEvent;
import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.service.IEventService;

@Component
public class AplicationEventService implements IEventService<Aplication> {

    private final KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.user.name:aplication}")
    private String topic;

    public AplicationEventService(KafkaTemplate<String, Event<?>> producer) {
        this.producer = producer;
    }

    @Override
    public void create(Aplication entity) {
        AplicationCreatedEvent event = new AplicationCreatedEvent(entity);
        this.producer.send(topic, event);
    }

    @Override
    public void update(Aplication entity) {
        AplicationUpdatedEvent event = new AplicationUpdatedEvent(entity);
        this.producer.send(topic, event);
    }

    @Override
    public void delete(Aplication entity) {
        AplicationDeletedEvent event = new AplicationDeletedEvent(entity);
        this.producer.send(topic, event);
    }

}
