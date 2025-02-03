package cloud.tteams.project.project.application.command.create;

import cloud.tteams.project.project.domain.Project;
import cloud.tteams.project.project.domain.service.IProjectDomainService;
import cloud.tteams.project.project.domain.valueobject.*;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class CreateProjectCommandHandler implements ICommandHandler<CreateProjectCommand> {

    private final IProjectDomainService service;
    private final Log logger = LogFactory.getLog(this.getClass());

    public CreateProjectCommandHandler(IProjectDomainService service) {
        this.service = service;
    }

    @Override
    public void handle(CreateProjectCommand command) {
        Project project;
        try {
            project = new Project(
                    new ProjectId(command.getId()),
                    new ProjectName(command.getName()),
                    new ProjectDescription(command.getDescription()),
                    new ProjectStartDate(command.getStartDate()),
                    new ProjectEstimatedEndDate(command.getEstimatedEndDate()),
                    command.getStatus(),
                    command.getPriority(),
                    new ProjectTags(command.getTags())
            );
        } catch (Exception handlingException) {
            logger.error("Unable to Handle the creation of the project: %s The error was: %s".formatted(command.getName(), handlingException.getMessage()));
            throw handlingException;
        }
        service.create(project);
    }
}
