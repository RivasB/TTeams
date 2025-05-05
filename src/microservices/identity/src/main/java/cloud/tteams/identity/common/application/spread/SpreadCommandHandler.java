package cloud.tteams.identity.common.application.spread;

import cloud.tteams.identity.organization.domain.service.IOrganizationService;
import cloud.tteams.identity.user.domain.service.IUserService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

@Component
public class SpreadCommandHandler implements ICommandHandler<SpreadCommand> {

    private final IUserService userService;
    private final IOrganizationService agencyService;

    public SpreadCommandHandler(IUserService userService, IOrganizationService agencyService) {
        this.userService = userService;
        this.agencyService = agencyService;
    }

    @Override
    public void handle(SpreadCommand command) {
        userService.spreadUsers();
    }

}
