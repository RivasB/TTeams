package cloud.tteams.project.project.infrastructure.service;

import cloud.tteams.share.config.context.UserContext;
import cloud.tteams.share.core.domain.notification.Notification;
import cloud.tteams.share.core.domain.notification.NotificationPriority;
import cloud.tteams.share.core.domain.notification.NotificationStatus;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.project.project.domain.Project;
import cloud.tteams.project.project.domain.event.ProjectCreatedEvent;
import cloud.tteams.project.project.domain.event.ProjectDeletedEvent;
import cloud.tteams.project.project.domain.event.ProjectUpdatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.event.Event;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class ProjectEventServiceImplementation implements IEventService<Project> {

    private final KafkaTemplate<String, Event<Notification>> producer;

    public ProjectEventServiceImplementation(KafkaTemplate<String, Event<Notification>> producer) {
        this.producer = producer;
    }

    @Value("${topic.project.name:notification}")
    private String topic;

    @Override
    public void create(Project project) {
        Notification notification = new Notification(
                UUID.randomUUID(),
                project.getId().getValue(),
                UserContext.getUserSession().getUserId(),
                "project",
                String.format("Your Project %s has been created successfully", project.getName()),
                LocalDateTime.now(),
                NotificationPriority.LOW,
                NotificationStatus.NEW
        );
        ProjectCreatedEvent create = new ProjectCreatedEvent(notification);
        this.producer.send(topic, create);
    }

    @Override
    public void update(Project project) {
        Notification notification = new Notification(
                UUID.randomUUID(),
                project.getId().getValue(),
                UserContext.getUserSession().getUserId(),
                "project",
                String.format("The Project named %s has been updated successfully", project.getName()),
                LocalDateTime.now(),
                NotificationPriority.LOW,
                NotificationStatus.NEW
        );
        ProjectUpdatedEvent update = new ProjectUpdatedEvent(notification);
        this.producer.send(topic, update);
    }

    @Override
    public void delete(Project project) {
        Notification notification = new Notification(
                UUID.randomUUID(),
                project.getId().getValue(),
                UserContext.getUserSession().getUserId(),
                "project",
                String.format("The Project named %s has been deleted successfully", project.getName()),
                LocalDateTime.now(),
                NotificationPriority.LOW,
                NotificationStatus.NEW
        );
        ProjectDeletedEvent delete = new ProjectDeletedEvent(notification);
        this.producer.send(topic, delete);
    }
}
