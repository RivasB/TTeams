package cloud.tteams.comment.comment.application.query.getall;

import cloud.tteams.share.core.domain.bus.query.IQuery;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public class GetAllCommentQuery implements IQuery {

    private final UUID task;
    private final Pageable pageable;

    public GetAllCommentQuery(UUID task, Pageable pageable) {
        this.task = task;
        this.pageable = pageable;
    }

    public UUID getTask() {
        return task;
    }

    public Pageable getPageable() {
        return pageable;
    }
}
