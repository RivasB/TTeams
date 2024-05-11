package cloud.tteams.identity.organization.application.command.create;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.identity.organization.domain.service.IOrganizationService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

@Component
public class CreateOrganizationCommandHandler implements ICommandHandler<CreateOrganizationCommand> {

    private final IOrganizationService service;

    public CreateOrganizationCommandHandler(IOrganizationService service) {
        this.service = service;
    }

    @Override
    public void handle(CreateOrganizationCommand command) {
        Organization organization = new Organization(command.getId(), command.getName(), command.getDescription(),
                command.getContact(), command.getState());
        service.create(organization);
    }
}
