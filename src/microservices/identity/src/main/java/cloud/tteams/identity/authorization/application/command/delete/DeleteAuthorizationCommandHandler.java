package cloud.tteams.identity.authorization.application.command.delete;

import cloud.tteams.identity.authorization.domain.service.IAuthorizationService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

@Component
public class DeleteAuthorizationCommandHandler implements ICommandHandler<DeleteAuthorizationCommand> {

    private final IAuthorizationService service;

    public DeleteAuthorizationCommandHandler(IAuthorizationService service) {
        this.service = service;
    }

    @Override
    public void handle(DeleteAuthorizationCommand command) {
        service.delete(command.id());
    }
}
