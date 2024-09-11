package cloud.tteams.identity.user.application.command.delete;

import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.identity.user.domain.service.IUserService;

@Component
public class DeleteUserCommandHandler implements ICommandHandler<DeleteUserCommand> {

    private final IUserService userService;

    public DeleteUserCommandHandler(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void handle(DeleteUserCommand command) {
        userService.delete(command.getId());
    }

}
