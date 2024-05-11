package cloud.tteams.identity.application.infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.application.domain.Aplication;
import cloud.tteams.identity.application.domain.event.AplicationCreatedEvent;
import cloud.tteams.identity.application.domain.event.AplicationDeletedEvent;
import cloud.tteams.identity.application.domain.event.AplicationUpdatedEvent;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.service.IEventService;

@Component
public class AplicationEventService implements IEventService<Aplication> {

    private final KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.user.name:application}")
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
