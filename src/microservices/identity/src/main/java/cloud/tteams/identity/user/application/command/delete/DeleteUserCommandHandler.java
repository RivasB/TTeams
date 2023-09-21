package cloud.tteams.identity.user.application.command.delete;

import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.identity.user.domain.UserId;
import cloud.tteams.identity.user.domain.service.IUserService;

@Component
public class DeleteUserCommandHandler implements ICommandHandler<DeleteUserCommand> {

    private IUserService userService;

    public DeleteUserCommandHandler(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void handle(DeleteUserCommand command) {
        UserId id = new UserId(command.getId());

        userService.delete(id);
    }

}
