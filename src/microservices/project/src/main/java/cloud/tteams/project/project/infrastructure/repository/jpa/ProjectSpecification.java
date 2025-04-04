package cloud.tteams.project.project.infrastructure.repository.jpa;

import cloud.tteams.project.project.domain.valueobject.ProjectPriority;
import cloud.tteams.project.project.domain.valueobject.ProjectStatus;
import cloud.tteams.project.project.infrastructure.repository.hibernate.ProjectEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.Map;

public class ProjectSpecification {

    public static Specification<ProjectEntity> buildSpecification(Map<String, Object> filters) {

        Specification<ProjectEntity> specification = Specification.where(getDeletedEqual(false));

        if (filters.containsKey("name")) {
            specification = specification.and(getNameContainingIgnoreCase((String) filters.get("name")));
        }
        if (filters.containsKey("description")) {
            specification = specification.and(getDescriptionContainingIgnoreCase((String) filters.get("description")));
        }
        if (filters.containsKey("startDate")) {
            specification = specification.and(getStartDateGreaterThanOrEqual((LocalDate) filters.get("startDate")));
        }
        if (filters.containsKey("estimatedEndDate")) {
            specification = specification.and(getEstimatedEndDateLessThanOrEqual((LocalDate) filters.get("estimatedEndDate")));
        }
        if (filters.containsKey("status")) {
            specification = specification.and(getStatusEqual((ProjectStatus) filters.get("status")));
        }
        if (filters.containsKey("priority")) {
            specification = specification.and(getPriorityEqual((ProjectPriority) filters.get("priority")));
        }
        if (filters.containsKey("tags")) {
            specification = specification.and(getTagsContainingIgnoreCase((String) filters.get("tags")));
        }
        return specification;
    }

    public static Specification<ProjectEntity> getNameContainingIgnoreCase(String name){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
    }

    public static Specification<ProjectEntity> getDescriptionContainingIgnoreCase(String description){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + description.toLowerCase() + "%"));
    }

    public static Specification<ProjectEntity> getStartDateGreaterThanOrEqual(LocalDate startDate){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("startDate"), startDate));
    }

    public static Specification<ProjectEntity> getEstimatedEndDateLessThanOrEqual(LocalDate estimatedEndDate){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("estimatedEndDate"), estimatedEndDate));
    }

    public static Specification<ProjectEntity> getStatusEqual(ProjectStatus status){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("status"), status));
    }

    public static Specification<ProjectEntity> getPriorityEqual(ProjectPriority priority){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("priority"), priority));
    }

    public static Specification<ProjectEntity> getTagsContainingIgnoreCase(String tag){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.isMember(tag.toLowerCase(), root.get("tags")));
    }

    public static Specification<ProjectEntity> getDeletedEqual(boolean deleted){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("deleted"), deleted));
    }
}
