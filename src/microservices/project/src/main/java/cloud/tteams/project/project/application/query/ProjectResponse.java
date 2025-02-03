package cloud.tteams.project.project.application.query;

import cloud.tteams.project.project.domain.*;
import cloud.tteams.project.project.domain.valueobject.ProjectPriority;
import cloud.tteams.project.project.domain.valueobject.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class ProjectResponse {
    private final UUID id;
    private final String name;
    private final String description;
    private final LocalDate startDate;
    private final LocalDate estimatedEndDate;
    private final ProjectStatus status;
    private final ProjectPriority priority;
    private final List<String> tags;

    public ProjectResponse(Project project) {
        this.id = project.getId().value();
        this.name = project.getName().value();
        this.description = project.getDescription().value();
        this.startDate = project.getStartDate().value();
        this.estimatedEndDate = project.getEstimatedEndDate() != null ? project.getEstimatedEndDate().value() : null;
        this.status = project.getStatus();
        this.priority = project.getPriority();
        this.tags = project.getTags() != null ? project.getTags().value().stream().toList() : List.of();
    }
}