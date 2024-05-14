package cloud.tteams.identity.authorization.application.command.update;

import cloud.tteams.identity.authorization.domain.Authorization;
import cloud.tteams.identity.authorization.domain.service.IAuthorizationService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

@Component
public class UpdateAuthorizationCommandHandler implements ICommandHandler<UpdateAuthorizationCommand> {

    private final IAuthorizationService service;

    public UpdateAuthorizationCommandHandler(IAuthorizationService service) {
        this.service = service;
    }

    @Override
    public void handle(UpdateAuthorizationCommand command) {
        Authorization authorization = new Authorization(command.getId(), command.getName(), command.getResource(),
                command.getAction(), command.getState());
        service.update(authorization);
    }
}
