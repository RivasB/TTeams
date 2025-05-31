package cloud.tteams.task.task.infrastructure.adapter.command;

import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.repository.ITaskCommandRepository;
import cloud.tteams.task.task.domain.valueobject.TaskAssignedUser;
import cloud.tteams.task.task.domain.valueobject.TaskId;
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

    private TaskEntity getExistingTask(TaskId taskId) {
        return readDataJPARepository.findById(taskId.getValue())
                .orElseThrow(TaskNotFoundException::new);
    }
}
