package cloud.tteams.project.project.domain;

import cloud.tteams.project.project.domain.valueobject.*;

public class Project {

    private final ProjectId id;

    private final ProjectName name;

    private final ProjectDescription description;

    private final ProjectStartDate startDate;

    private final ProjectEstimatedEndDate estimatedEndDate;

    private final ProjectStatus status;

    private final ProjectPriority priority;

    private final ProjectTags tags;

    public Project(ProjectId id, ProjectName name, ProjectDescription description, ProjectStartDate startDate,
                   ProjectEstimatedEndDate estimatedEndDate, ProjectStatus status, ProjectPriority priority,
                   ProjectTags tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.estimatedEndDate = estimatedEndDate;
        this.status = status;
        this.priority = priority;
        this.tags = tags;
    }

    public ProjectId getId() {
        return id;
    }

    public ProjectName getName() {
        return name;
    }

    public ProjectDescription getDescription() {
        return description;
    }

    public ProjectStartDate getStartDate() {
        return startDate;
    }

    public ProjectEstimatedEndDate getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public ProjectPriority getPriority() {
        return priority;
    }

    public ProjectTags getTags() {
        return tags;
    }
}
