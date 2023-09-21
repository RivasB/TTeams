package cloud.tteams.identity.agency.application.command.delete;

import cloud.tteams.identity.agency.domain.AgencyId;
import cloud.tteams.identity.agency.domain.service.IAgencyService;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;

@Component
public class DeleteAgencyCommandHandler implements ICommandHandler<DeleteAgencyCommand> {

    private final IAgencyService agencyService;

    public DeleteAgencyCommandHandler(IAgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @Override
    public void handle(DeleteAgencyCommand command) {
        AgencyId id = new AgencyId(command.getId());

        agencyService.delete(id);
    }

}
