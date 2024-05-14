package cloud.tteams.identity.authorization.application.command.create;

import cloud.tteams.identity.authorization.domain.Authorization;
import cloud.tteams.identity.authorization.domain.service.IAuthorizationService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

@Component
public class CreateAuthorizationCommandHandler implements ICommandHandler<CreateAuthorizationCommand> {

    private final IAuthorizationService service;

    public CreateAuthorizationCommandHandler(IAuthorizationService service) {
        this.service = service;
    }

    @Override
    public void handle(CreateAuthorizationCommand command) {
        Authorization authorization = new Authorization(command.getId(), command.getName(), command.getResource(),
                command.getAction(), command.getState());
        service.create(authorization);
    }
}
