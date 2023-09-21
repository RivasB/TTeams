package cloud.tteams.identity.agency.infrastructure.service;

import cloud.tteams.identity.agency.domain.Agency;
import cloud.tteams.identity.agency.domain.event.CreateAgencyEvent;
import cloud.tteams.identity.agency.domain.event.DeleteAgencyEvent;
import cloud.tteams.identity.agency.domain.event.UpdateAgencyEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.service.IEventService;

@Service
public class AgencyEventService implements IEventService<Agency> {

    private final KafkaTemplate<String, Event<?>> producer;

    public AgencyEventService(KafkaTemplate<String, Event<?>> producer) {
        this.producer = producer;
    }

    @Value("${topic.agency.name:agency}")
    private String topic;

    @Override
    public void create(Agency entity) {
        CreateAgencyEvent event = new CreateAgencyEvent(entity);
        this.producer.send(topic, event);
    }

    @Override
    public void update(Agency entity) {
        UpdateAgencyEvent event = new UpdateAgencyEvent(entity);
        this.producer.send(topic, event);
    }

    @Override
    public void delete(Agency entity) {
        DeleteAgencyEvent event = new DeleteAgencyEvent(entity);
        this.producer.send(topic, event);
    }

}
