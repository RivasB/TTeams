package cloud.tteams.identity.telephone_operator.infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;
import cloud.tteams.identity.telephone_operator.domain.event.TelephoneOperatorCreatedEvent;
import cloud.tteams.identity.telephone_operator.domain.event.TelephoneOperatorDeletedEvent;
import cloud.tteams.identity.telephone_operator.domain.event.TelephoneOperatorUpdatedEvent;

@Component
public class TelephoneOperatorEventService implements IEventService<TelephoneOperator> {

    private final KafkaTemplate<String, Event<?>> producer;

    public TelephoneOperatorEventService(KafkaTemplate<String, Event<?>> producer) {
        this.producer = producer;
    }

    @Value("${topic.user.name:telephone_operator}")
    private String topic;

    @Override
    public void create(TelephoneOperator entity) {
        TelephoneOperatorCreatedEvent create = new TelephoneOperatorCreatedEvent(entity);
        this.producer.send(topic, create);

    }

    @Override
    public void update(TelephoneOperator entity) {
        TelephoneOperatorUpdatedEvent delete = new TelephoneOperatorUpdatedEvent(entity);
        this.producer.send(topic, delete);
    }

    @Override
    public void delete(TelephoneOperator entity) {
        TelephoneOperatorDeletedEvent delete = new TelephoneOperatorDeletedEvent(entity);
        this.producer.send(topic, delete);
    }

}
