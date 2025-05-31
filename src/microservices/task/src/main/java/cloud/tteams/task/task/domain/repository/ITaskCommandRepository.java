package cloud.tteams.task.task.domain.repository;


import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.valueobject.TaskAssignedUser;
import cloud.tteams.task.task.domain.valueobject.TaskId;

public interface ITaskCommandRepository {

    void create(Task task);

    void update(Task task);

    void delete(TaskId taskId);

    void assign(TaskId id, TaskAssignedUser user);
}
