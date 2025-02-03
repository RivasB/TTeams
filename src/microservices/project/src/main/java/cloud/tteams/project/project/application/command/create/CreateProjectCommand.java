package cloud.tteams.project.project.application.command.create;

import cloud.tteams.project.project.domain.valueobject.ProjectPriority;
import cloud.tteams.project.project.domain.valueobject.ProjectStatus;
import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
public class CreateProjectCommand implements ICommand {

    private final UUID id;
    private final String name;
    private final String description;
    private final LocalDate startDate;
    private final LocalDate estimatedEndDate;
    private final ProjectStatus status = ProjectStatus.PENDING;
    private final ProjectPriority priority;
    private final List<String> tags;

    public CreateProjectCommand(CreateProjectRequest request) {
        this.id = UUID.randomUUID();
        this.name = request.name();
        this.description = request.description();
        this.startDate = request.startDate() != null ? request.startDate() : null;
        this.estimatedEndDate = request.estimatedEndDate() != null ? request.estimatedEndDate() : null;
        this.priority = request.priority() != null ? request.priority() : ProjectPriority.LOW;
        this.tags = request.tags();
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(id, "CREATED");
    }
}
