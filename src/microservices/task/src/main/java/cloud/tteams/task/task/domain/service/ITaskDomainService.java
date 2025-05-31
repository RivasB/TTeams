package cloud.tteams.task.task.domain.service;

import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.valueobject.*;
import org.springframework.data.domain.Pageable;

public interface ITaskDomainService {

    void create(Task task);

    void update(Task task);

    void delete(TaskId taskId);

    void assign(TaskId id, TaskAssignedUser user);

    void changeStatus(TaskId id, TaskStatus status);

    void logTime(TaskId id, TaskLoggedTime time);

    void setEffort(TaskId id, TaskEstimatedEffort effort);

    void setOrChangeSprint(TaskId taskId, TaskSprint sprint);

    Task findById(TaskId id);

    MessagePaginatedResponse findAll(Pageable pageable);

}
