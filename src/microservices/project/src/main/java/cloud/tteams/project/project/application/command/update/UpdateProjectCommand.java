package cloud.tteams.project.project.application.command.update;

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
public class UpdateProjectCommand implements ICommand {
    private final UUID id;
    private final String name;
    private final String description;
    private final LocalDate startDate;
    private final LocalDate estimatedEndDate;
    private final ProjectStatus status;
    private final ProjectPriority priority;
    private final List<String> tags;

    public UpdateProjectCommand(UpdateProjectRequest request) {
        this.id = request.id();
        this.name = request.name();
        this.description = request.description();
        this.startDate = request.startDate();
        this.estimatedEndDate = request.estimatedEndDate();
        this.status = request.status();
        this.priority = request.priority();
        this.tags = request.tags();
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(id, "UPDATED");
    }
}
