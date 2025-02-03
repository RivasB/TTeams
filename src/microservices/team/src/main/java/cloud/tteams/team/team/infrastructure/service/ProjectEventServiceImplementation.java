package cloud.tteams.project.project.infrastructure.service;

import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.project.project.domain.Project;
import cloud.tteams.project.project.domain.event.ProjectCreatedEvent;
import cloud.tteams.project.project.domain.event.ProjectDeletedEvent;
import cloud.tteams.project.project.domain.event.ProjectUpdatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.event.Event;

@Component
public class ProjectEventServiceImplementation implements IEventService<Project> {
    private final KafkaTemplate<String, Event<?>> producer;

    public ProjectEventServiceImplementation(KafkaTemplate<String, Event<?>> producer) {
        this.producer = producer;
    }

    @Value("${topic.project.name:project}")
    private String topic;

    @Override
    public void create(Project project) {
        ProjectCreatedEvent create = new ProjectCreatedEvent(project);
        this.producer.send(topic, create);
    }

    @Override
    public void update(Project project) {
        ProjectUpdatedEvent update = new ProjectUpdatedEvent(project);
        this.producer.send(topic, update);
    }

    @Override
    public void delete(Project project) {
        ProjectDeletedEvent delete = new ProjectDeletedEvent(project);
        this.producer.send(topic, delete);
    }
}
