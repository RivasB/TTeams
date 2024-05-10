package cloud.tteams.share.comment.domain.event;


import cloud.tteams.share.comment.domain.Comment;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class CommentCreatedEvent extends Event<Comment> {

    public CommentCreatedEvent(Comment data) {
        super(EventType.CREATED, data);
    }

}
