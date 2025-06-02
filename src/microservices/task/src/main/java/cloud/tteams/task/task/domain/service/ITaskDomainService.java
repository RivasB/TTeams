package cloud.tteams.task.task.domain.service;

import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.valueobject.*;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ITaskDomainService {

    void create(Task task);

    void update(Task task);

    void delete(TaskId id);

    void assign(TaskId id, TaskAssignedUser user);

    void changeStatus(TaskId id, TaskStatus status);

    void logTime(TaskId id, TaskLoggedTime time);

    void setEffort(TaskId id, TaskEstimatedEffort effort);

    void setOrChangeSprint(TaskId id, TaskSprint sprint);

    Task findById(TaskId id);

    MessagePaginatedResponse findAll(Pageable pageable);

    MessagePaginatedResponse findAllFiltered(Map<String, Object> filters, Pageable pageable);

}
