package ec.gob.registrocivil.identity.agency.application.command.delete;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.agency.domain.AgencyId;
import ec.gob.registrocivil.identity.agency.domain.service.IAgencyService;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandHandler;

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
