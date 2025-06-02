package cloud.tteams.task.task.domain.repository;

import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.valueobject.TaskId;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ITaskQueryRepository {

    Task findById(TaskId id);

    MessagePaginatedResponse findAll(Pageable pageable);

    MessagePaginatedResponse findAllFiltered(Map<String, Object> filters, Pageable pageable);
}
