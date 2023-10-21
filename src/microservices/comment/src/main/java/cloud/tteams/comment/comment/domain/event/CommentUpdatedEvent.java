package cloud.tteams.comment.comment.domain.event;


import cloud.tteams.comment.comment.domain.Comment;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class CommentUpdatedEvent extends Event<Comment> {

    public CommentUpdatedEvent(Comment data) {
        super(EventType.UPDATED, data);
    }

}
