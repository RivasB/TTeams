package cloud.tteams.project.project.application.command.update;

import cloud.tteams.project.project.domain.valueobject.ProjectPriority;
import cloud.tteams.project.project.domain.valueobject.ProjectStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record UpdateProjectRequest(
        @NotNull(message = "Project ID is necessary") UUID id,
        String name,
        String description, LocalDate startDate,
        LocalDate estimatedEndDate,
        ProjectStatus status,
        ProjectPriority priority,
        List<String> tags) {}
