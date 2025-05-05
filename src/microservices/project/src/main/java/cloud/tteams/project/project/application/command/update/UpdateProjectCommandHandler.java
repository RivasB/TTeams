package cloud.tteams.project.project.application.command.update;

import cloud.tteams.project.project.domain.Project;
import cloud.tteams.project.project.domain.service.IProjectDomainService;
import cloud.tteams.project.project.domain.valueobject.*;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class UpdateProjectCommandHandler implements ICommandHandler<UpdateProjectCommand> {

    private final IProjectDomainService service;
    private final Log logger = LogFactory.getLog(this.getClass());

    public UpdateProjectCommandHandler(IProjectDomainService service) {
        this.service = service;
    }

    @Override
    public void handle(UpdateProjectCommand command) {
        Project project;
        try {
            project = new Project(
                    new ProjectId(command.getId()),
                    new ProjectName(
                            command.getName()!=null ? command.getName() : null
                    ),
                    new ProjectDescription(
                            command.getDescription()!=null ? command.getDescription() : null
                    ),
                    new ProjectStartDate(
                            command.getStartDate()!=null ? command.getStartDate() : null
                    ),
                    new ProjectEstimatedEndDate(
                            command.getEstimatedEndDate()!=null ? command.getEstimatedEndDate() : null
                    ),
                    command.getStatus()!=null ? command.getStatus() : null,
                    command.getPriority()!=null ? command.getPriority() : null,
                    new ProjectTags(
                            command.getTags()!=null ? command.getTags() : null
                    )
            );
        } catch (Exception handlingException) {
            logger.error("Unable to Handle the creation of the project: %s during an setstatus request. The error was: %s".formatted(command.getName(), handlingException.getMessage()));
            throw handlingException;
        }
        service.update(project);
    }

}
