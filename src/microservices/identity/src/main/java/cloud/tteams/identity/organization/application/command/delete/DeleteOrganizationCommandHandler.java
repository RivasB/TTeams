package cloud.tteams.identity.organization.application.command.delete;

import cloud.tteams.identity.organization.domain.service.IOrganizationService;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;

@Component
public class DeleteOrganizationCommandHandler implements ICommandHandler<DeleteOrganizationCommand> {

    private final IOrganizationService service;

    public DeleteOrganizationCommandHandler(IOrganizationService service) {
        this.service = service;
    }

    @Override
    public void handle(DeleteOrganizationCommand command) {
        service.delete(command.getId());
    }

}
