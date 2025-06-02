package cloud.tteams.task.task.infrastructure.adapter.query;


import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.task.task.application.query.TaskResponse;
import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.repository.ITaskQueryRepository;
import cloud.tteams.task.task.domain.valueobject.TaskId;
import cloud.tteams.task.task.infrastructure.exception.TaskNotFoundException;
import cloud.tteams.task.task.infrastructure.repository.hibernate.TaskEntity;
import cloud.tteams.task.task.infrastructure.repository.jpa.TaskSpecification;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Primary
public class TaskQueryRepositoryImplementation implements ITaskQueryRepository {

    private final ITaskQueryJPARepository jpaRepository;

    public TaskQueryRepositoryImplementation(final ITaskQueryJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Task findById(TaskId id) {
        TaskEntity taskEntity = jpaRepository.findById(id.value())
                .orElseThrow(TaskNotFoundException::new);
        return taskEntity.toAggregate();
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        Page<TaskEntity> page = jpaRepository.findAll(pageable);
        return this.result(page);
    }

    @Override
    public MessagePaginatedResponse findAllFiltered(Map<String, Object> filters, Pageable pageable) {
        Specification<TaskEntity> specification = TaskSpecification.buildSpecification(filters);
        Page<TaskEntity> page = jpaRepository.findAll(specification, pageable);
        return this.result(page);
    }


    private MessagePaginatedResponse result(Page<TaskEntity> page) {
        List<TaskResponse> response = page.stream()
                .map(item -> new TaskResponse(item.toAggregate())).toList();
        return new MessagePaginatedResponse(response, page);
    }

}
