package cloud.tteams.project.project.application;

import cloud.tteams.project.project.domain.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ProjectResponse {
    private final UUID id;

    private final String name;

    private final String description;

    private final LocalDate startDate;

    private final LocalDate estimatedEndDate;

    private final ProjectStatus status;

    private final ProjectPriority priority;

    private final List<String> tags;

    public ProjectResponse(UUID id, String name, String description, LocalDate startDate, LocalDate estimatedEndDate,
                           ProjectStatus status, ProjectPriority priority, List<String> tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.estimatedEndDate = estimatedEndDate;
        this.status = status;
        this.priority = priority;
        this.tags = tags;
    }

    public ProjectResponse(Project project) {
        this.id = project.getId().value();
        this.name = project.getName().value();
        this.description = project.getDescription().value();
        this.startDate = project.getStartDate().value();
        this.estimatedEndDate = project.getEstimatedEndDate().value();
        this.status = project.getStatus();
        this.priority = project.getPriority();
        this.tags = null;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public ProjectPriority getPriority() {
        return priority;
    }

    public List<String> getTags() {
        return tags;
    }
}
