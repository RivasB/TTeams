package cloud.tteams.task.task.infrastructure.adapter.command;

import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.repository.ITaskCommandRepository;
import cloud.tteams.task.task.domain.valueobject.*;
import cloud.tteams.task.task.infrastructure.adapter.query.ITaskQueryJPARepository;
import cloud.tteams.task.task.infrastructure.exception.TaskNotFoundException;
import cloud.tteams.task.task.infrastructure.repository.hibernate.TaskEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TaskCommandRepositoryImplementation implements ITaskCommandRepository {

    private final ITaskCommandJPARepository jpaRepository;

    private final ITaskQueryJPARepository readDataJPARepository;

    public TaskCommandRepositoryImplementation(final ITaskCommandJPARepository jpaRepository, ITaskQueryJPARepository readDataJPARepository) {
        this.jpaRepository = jpaRepository;
        this.readDataJPARepository = readDataJPARepository;
    }

    @Override
    public void create(Task task) {
        jpaRepository.save(new TaskEntity(task));
    }

    @Override
    public void update(Task task) {
        TaskEntity existingTask = getExistingTask(task.getId());
        existingTask.update(task);
        jpaRepository.save(existingTask);
    }

    @Override
    public void delete(TaskId taskId) {
        TaskEntity toDelete = getExistingTask(taskId);
        jpaRepository.delete(toDelete);
    }

    @Override
    public void assign(TaskId id, TaskAssignedUser user) {
        TaskEntity toAssign = getExistingTask(id);
        toAssign.assignUser(user.value());
        jpaRepository.save(toAssign);
    }

    @Override
    public void changeStatus(TaskId id, TaskStatus status) {
        TaskEntity toChange = getExistingTask(id);
        toChange.changeStatus(status);
        jpaRepository.save(toChange);
    }

    @Override
    public void logTime(TaskId id, TaskLoggedTime time) {
        TaskEntity toLog = getExistingTask(id);
        toLog.logTime(time.getValue());
        jpaRepository.save(toLog);
    }

    @Override
    public void setEffort(TaskId id, TaskEstimatedEffort effort) {
        TaskEntity toSet = getExistingTask(id);
        toSet.logTime(effort.value());
        jpaRepository.save(toSet);
    }

    @Override
    public void setOrChangeSprint(TaskId id, TaskSprint sprint) {
        TaskEntity toSet = getExistingTask(id);
        toSet.setOrChangeSprint(sprint.value());
        jpaRepository.save(toSet);
    }

    private TaskEntity getExistingTask(TaskId taskId) {
        return readDataJPARepository.findById(taskId.getValue())
                .orElseThrow(TaskNotFoundException::new);
    }
}
