package cloud.tteams.comment.comment.application.query.getall;

import cloud.tteams.share.core.domain.bus.query.IQuery;
import org.springframework.data.domain.Pageable;

public class GetAllCommentQuery implements IQuery {

    private final String task;
    private final Pageable pageable;

    public GetAllCommentQuery(String task, Pageable pageable) {
        this.task = task;
        this.pageable = pageable;
    }

    public String getTask() {
        return task;
    }

    public Pageable getPageable() {
        return pageable;
    }
}
