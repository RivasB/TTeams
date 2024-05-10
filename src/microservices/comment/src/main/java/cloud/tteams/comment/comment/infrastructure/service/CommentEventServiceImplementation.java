package cloud.tteams.comment.comment.infrastructure.service;

import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.comment.comment.domain.event.CommentCreatedEvent;
import cloud.tteams.comment.comment.domain.event.CommentDeletedEvent;
import cloud.tteams.comment.comment.domain.event.CommentUpdatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.event.Event;

@Component
public class CommentEventServiceImplementation implements IEventService<Comment> {
    private final KafkaTemplate<String, Event<?>> producer;

    public CommentEventServiceImplementation(KafkaTemplate<String, Event<?>> producer) {
        this.producer = producer;
    }

    @Value("${topic.comment.name:comment}")
    private String topic;

    @Override
    public void create(Comment comment) {
        CommentCreatedEvent create = new CommentCreatedEvent(comment);
        this.producer.send(topic, create);
    }

    @Override
    public void update(Comment comment) {
        CommentUpdatedEvent update = new CommentUpdatedEvent(comment);
        this.producer.send(topic, update);
    }

    @Override
    public void delete(Comment comment) {
        CommentDeletedEvent delete = new CommentDeletedEvent(comment);
        this.producer.send(topic, delete);
    }
}
