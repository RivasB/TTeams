package cloud.tteams.task.task.domain.repository;


import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.valueobject.*;

public interface ITaskCommandRepository {

    void create(Task task);

    void update(Task task);

    void delete(TaskId taskId);

    void assign(TaskId id, TaskAssignedUser user);

    void changeStatus(TaskId id, TaskStatus status);

    void logTime(TaskId id, TaskLoggedTime time);

    void setEffort(TaskId id, TaskEstimatedEffort effort);

    void setOrChangeSprint(TaskId id, TaskSprint sprint);
}
