package cloud.tteams.project.project.application.command.delete;

import cloud.tteams.project.project.domain.service.IProjectDomainService;
import cloud.tteams.project.project.domain.valueobject.ProjectId;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class DeleteProjectCommandHandler implements ICommandHandler<DeleteProjectCommand> {

    private final IProjectDomainService service;
    private final Log logger = LogFactory.getLog(this.getClass());

    public DeleteProjectCommandHandler(IProjectDomainService service) {
        this.service = service;
    }

    @Override
    public void handle(DeleteProjectCommand command) {
        ProjectId idToDelete;
        try {
            idToDelete = new ProjectId(command.getUuid());
        }
        catch (Exception handlingException) {
            logger.error("Unable to Handle the deletion of the project with ID: %s The error was: %s".formatted(command.getUuid(), handlingException.getMessage()));
            throw handlingException;
        }
        service.delete(idToDelete);
    }
}
