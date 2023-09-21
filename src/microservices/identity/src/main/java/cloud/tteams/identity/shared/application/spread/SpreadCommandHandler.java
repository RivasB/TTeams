package cloud.tteams.identity.shared.application.spread;

import cloud.tteams.identity.agency.domain.service.IAgencyService;
import cloud.tteams.identity.geographiclocation.domain.service.IGeographicLocationService;
import cloud.tteams.identity.user.domain.service.IUserService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

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
