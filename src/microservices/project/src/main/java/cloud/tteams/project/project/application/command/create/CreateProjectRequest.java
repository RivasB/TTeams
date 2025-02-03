package cloud.tteams.project.project.application.command.create;

import cloud.tteams.project.project.domain.valueobject.ProjectPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CreateProjectRequest(
        @NotNull(message = "Project Name is required") @NotBlank(message = "Project Name can not be blank") String name,
        String description,
        LocalDate startDate,
        LocalDate estimatedEndDate,
        ProjectPriority priority,
        @NotNull(message = "Project must have at least one tag") List<String> tags
) {}
