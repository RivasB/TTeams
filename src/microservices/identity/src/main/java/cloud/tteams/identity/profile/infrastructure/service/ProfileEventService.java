package cloud.tteams.identity.profile.infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.event.ProfileCreatedEvent;
import cloud.tteams.identity.profile.domain.event.ProfileUpdatedEvent;
import cloud.tteams.identity.profile.domain.event.ProfileDeletedEvent;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.service.IEventService;

@Service
public class ProfileEventService implements IEventService<Profile> {

    private final KafkaTemplate<String, Event> producer;

    public ProfileEventService(KafkaTemplate<String, Event> producer) {
        this.producer = producer;
    }

    @Value("${topic.user.name:profiles}")
    private String topic;

    @Override
    public void create(Profile entity) {
        //ProfileCreatedEvent event = new ProfileCreatedEvent(entity);
        //this.producer.send(topic, event);
    }

    @Override
    public void update(Profile entity) {
        //ProfileUpdatedEvent event = new ProfileUpdatedEvent(entity);
        //this.producer.send(topic, event);
    }

    @Override
    public void delete(Profile entity) {
        //ProfileDeletedEvent event = new ProfileDeletedEvent(entity);
        //this.producer.send(topic, event);
    }

}
