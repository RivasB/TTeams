package cloud.tteams.identity.organization.application.command.update;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.identity.organization.domain.service.IOrganizationService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

@Component
public class UpdateOrganizationCommandHandler implements ICommandHandler<UpdateOrganizationCommand> {

    private final IOrganizationService service;

    public UpdateOrganizationCommandHandler(IOrganizationService service) {
        this.service = service;
    }

    @Override
    public void handle(UpdateOrganizationCommand command) {
        Organization organization = new Organization(command.getId(), command.getName(), command.getDescription(),
                command.getContact(), command.getState());
        service.update(organization);
    }
}
