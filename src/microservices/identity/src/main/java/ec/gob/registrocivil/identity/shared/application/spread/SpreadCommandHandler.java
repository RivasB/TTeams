package ec.gob.registrocivil.identity.shared.application.spread;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.agency.domain.service.IAgencyService;
import ec.gob.registrocivil.identity.geographiclocation.domain.service.IGeographicLocationService;
import ec.gob.registrocivil.identity.user.domain.service.IUserService;

@Component
public class SpreadCommandHandler implements ICommandHandler<SpreadCommand> {

    private final IUserService userService;
    private final IAgencyService agencyService;
    private final IGeographicLocationService locationService;

    public SpreadCommandHandler(IUserService userService, IAgencyService agencyService,
            IGeographicLocationService locationService) {
        this.userService = userService;
        this.agencyService = agencyService;
        this.locationService = locationService;
    }

    @Override
    public void handle(SpreadCommand command) {
        userService.spreadUsers();
        agencyService.spreadAgencys();
        locationService.SpreadLocations();
    }

}
