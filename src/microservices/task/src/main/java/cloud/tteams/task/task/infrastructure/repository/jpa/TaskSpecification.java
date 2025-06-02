package cloud.tteams.task.task.infrastructure.repository.jpa;

import cloud.tteams.task.task.domain.valueobject.TaskPriority;
import cloud.tteams.task.task.domain.valueobject.TaskStatus;
import cloud.tteams.task.task.domain.valueobject.TaskType;
import cloud.tteams.task.task.infrastructure.repository.hibernate.TaskEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

public class TaskSpecification {

    public static Specification<TaskEntity> buildSpecification(Map<String, Object> filters) {
        Specification<TaskEntity> specification = Specification.where(null);

        if (filters.containsKey("name")) {
            specification = specification.and(getNameContainingIgnoreCase((String) filters.get("name")));
        }
        if (filters.containsKey("description")) {
            specification = specification.and(getDescriptionContainingIgnoreCase((String) filters.get("description")));
        }
        if (filters.containsKey("createdDate")) {
            specification = specification.and(getCreatedDateGreaterThanOrEqual((LocalDate) filters.get("createdDate")));
        }
        if (filters.containsKey("startDate")) {
            specification = specification.and(getStartDateGreaterThanOrEqual((LocalDate) filters.get("startDate")));
        }
        if (filters.containsKey("estimatedEndDate")) {
            specification = specification.and(getEstimatedEndDateLessThanOrEqual((LocalDate) filters.get("estimatedEndDate")));
        }
        if (filters.containsKey("status")) {
            specification = specification.and(getStatusEqual((TaskStatus) filters.get("status")));
        }
        if (filters.containsKey("priority")) {
            specification = specification.and(getPriorityEqual((TaskPriority) filters.get("priority")));
        }
        if (filters.containsKey("type")) {
            specification = specification.and(getTypeEqual((TaskType) filters.get("type")));
        }
        if (filters.containsKey("project")) {
            specification = specification.and(getProjectEqual((UUID) filters.get("project")));
        }
        if (filters.containsKey("assignedUser")) {
            specification = specification.and(getAssignedUserEqual((UUID) filters.get("assignedUser")));
        }
        if (filters.containsKey("tags")) {
            specification = specification.and(getTagsContainingIgnoreCase((String) filters.get("tags")));
        }
        return specification;
    }

    public static Specification<TaskEntity> getNameContainingIgnoreCase(String name) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<TaskEntity> getDescriptionContainingIgnoreCase(String description) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("description")), "%" + description.toLowerCase() + "%");
    }

    public static Specification<TaskEntity> getCreatedDateGreaterThanOrEqual(LocalDate createdDate) {
        return (root, query, cb) ->
                cb.greaterThanOrEqualTo(root.get("createdDate"), createdDate);
    }

    public static Specification<TaskEntity> getStartDateGreaterThanOrEqual(LocalDate startDate) {
        return (root, query, cb) ->
                cb.greaterThanOrEqualTo(root.get("startDate"), startDate);
    }

    public static Specification<TaskEntity> getEstimatedEndDateLessThanOrEqual(LocalDate estimatedEndDate) {
        return (root, query, cb) ->
                cb.lessThanOrEqualTo(root.get("estimatedEndDate"), estimatedEndDate);
    }

    public static Specification<TaskEntity> getStatusEqual(TaskStatus status) {
        return (root, query, cb) ->
                cb.equal(root.get("status"), status);
    }

    public static Specification<TaskEntity> getPriorityEqual(TaskPriority priority) {
        return (root, query, cb) ->
                cb.equal(root.get("priority"), priority);
    }

    public static Specification<TaskEntity> getTypeEqual(TaskType type) {
        return (root, query, cb) ->
                cb.equal(root.get("type"), type);
    }

    public static Specification<TaskEntity> getProjectEqual(UUID project) {
        return (root, query, cb) ->
                cb.equal(root.get("project"), project);
    }

    public static Specification<TaskEntity> getAssignedUserEqual(UUID assignedUser) {
        return (root, query, cb) ->
                cb.equal(root.get("assignedUser"), assignedUser);
    }

    public static Specification<TaskEntity> getTagsContainingIgnoreCase(String tag) {
        return (root, query, cb) ->
                cb.isMember(tag.toLowerCase(), root.get("tags"));
    }
}