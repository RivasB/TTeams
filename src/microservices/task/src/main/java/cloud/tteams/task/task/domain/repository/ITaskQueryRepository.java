package cloud.tteams.task.task.domain.repository;

import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.valueobject.TaskId;
import org.springframework.data.domain.Pageable;

public interface ITaskQueryRepository {

    Task findById(TaskId id);

    MessagePaginatedResponse findAll(Pageable pageable);

}
