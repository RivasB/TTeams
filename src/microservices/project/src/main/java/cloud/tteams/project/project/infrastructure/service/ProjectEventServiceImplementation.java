package cloud.tteams.project.project.infrastructure.service;

import cloud.tteams.share.config.context.UserContext;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;
import cloud.tteams.share.core.domain.event.message.notification.NotificationPriority;
import cloud.tteams.share.core.domain.event.message.notification.NotificationStatus;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.project.project.domain.Project;
import cloud.tteams.project.project.domain.event.ProjectCreatedEvent;
import cloud.tteams.project.project.domain.event.ProjectDeletedEvent;
import cloud.tteams.project.project.domain.event.ProjectUpdatedEvent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.event.Event;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class ProjectEventServiceImplementation implements IEventService<Project> {

    private final KafkaTemplate<String, Event> producer;

    public ProjectEventServiceImplementation(KafkaTemplate<String, Event> producer) {
        this.producer = producer;
    }

    private static final Log log = LogFactory.getLog(ProjectEventServiceImplementation.class);

    @Value("${topic.project.name:notification}")
    private String topic;

    @Override
    public void create(Project project) {
        NotificationMessage notificationMessage = new NotificationMessage(
                UUID.randomUUID(),
                project.getId().getValue(),
                UserContext.getUserSession().getUserId(),
                "project",
                String.format("Your Project %s has been created successfully", project.getName()),
                LocalDateTime.now(),
                NotificationPriority.LOW,
                NotificationStatus.NEW
        );
        ProjectCreatedEvent create = new ProjectCreatedEvent(notificationMessage);
        this.producer.send(topic, create);
        log.info("A new CREATED notification has been sent successfully");
    }

    @Override
    public void update(Project project) {
        NotificationMessage notificationMessage = new NotificationMessage(
                UUID.randomUUID(),
                project.getId().getValue(),
                UserContext.getUserSession().getUserId(),
                "project",
                String.format("The Project named %s has been updated successfully", project.getName()),
                LocalDateTime.now(),
                NotificationPriority.LOW,
                NotificationStatus.NEW
        );
        ProjectUpdatedEvent update = new ProjectUpdatedEvent(notificationMessage);
        this.producer.send(topic, update);
        log.info("A new UPDATED notification has been sent successfully");
    }

    @Override
    public void delete(Project project) {
        NotificationMessage notificationMessage = new NotificationMessage(
                UUID.randomUUID(),
                project.getId().getValue(),
                UserContext.getUserSession().getUserId(),
                "project",
                String.format("The Project named %s has been deleted successfully", project.getName()),
                LocalDateTime.now(),
                NotificationPriority.LOW,
                NotificationStatus.NEW
        );
        ProjectDeletedEvent delete = new ProjectDeletedEvent(notificationMessage);
        this.producer.send(topic, delete);
        log.info("A new DELETED notification has been sent successfully");
    }
}
