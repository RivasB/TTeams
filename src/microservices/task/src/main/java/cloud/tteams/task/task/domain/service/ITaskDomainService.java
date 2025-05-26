package cloud.tteams.task.task.domain.service;

import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.valueobject.TaskId;
import org.springframework.data.domain.Pageable;

public interface ITaskDomainService {

    void create(Task task);

    void update(Task task);

    void delete(TaskId taskId);

    Task findById(TaskId id);

    MessagePaginatedResponse findAll(Pageable pageable);

}
