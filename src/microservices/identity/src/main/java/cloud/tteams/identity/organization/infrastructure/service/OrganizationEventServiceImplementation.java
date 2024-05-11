package cloud.tteams.identity.organization.infrastructure.service;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.identity.organization.domain.event.CreateOrganizationEvent;
import cloud.tteams.identity.organization.domain.event.DeleteOrganizationEvent;
import cloud.tteams.identity.organization.domain.event.UpdateOrganizationEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.service.IEventService;

@Service
public class OrganizationEventServiceImplementation implements IEventService<Organization> {

    private final KafkaTemplate<String, Event<?>> producer;

    public OrganizationEventServiceImplementation(KafkaTemplate<String, Event<?>> producer) {
        this.producer = producer;
    }

    @Value("${topic.organization.name:organization}")
    private String topic;

    @Override
    public void create(Organization entity) {
        CreateOrganizationEvent event = new CreateOrganizationEvent(entity);
        this.producer.send(topic, event);
    }

    @Override
    public void update(Organization entity) {
        UpdateOrganizationEvent event = new UpdateOrganizationEvent(entity);
        this.producer.send(topic, event);
    }

    @Override
    public void delete(Organization entity) {
        DeleteOrganizationEvent event = new DeleteOrganizationEvent(entity);
        this.producer.send(topic, event);
    }

}
