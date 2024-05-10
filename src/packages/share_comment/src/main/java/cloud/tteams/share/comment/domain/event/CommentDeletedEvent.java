package cloud.tteams.share.comment.domain.event;


import cloud.tteams.share.comment.domain.Comment;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class CommentDeletedEvent extends Event<Comment> {

    public CommentDeletedEvent(Comment data) {
        super(EventType.DELETED, data);
    }

}
