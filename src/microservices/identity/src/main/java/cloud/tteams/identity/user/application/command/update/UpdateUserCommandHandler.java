package cloud.tteams.identity.user.application.command.update;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.service.IProfileService;
import cloud.tteams.identity.user.domain.*;
import cloud.tteams.identity.user.domain.service.IUserService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserCommandHandler implements ICommandHandler<UpdateUserCommand> {

    private final IUserService userService;
    private final IProfileService profileService;

    public UpdateUserCommandHandler(IUserService userService, IProfileService profileService) {
        this.userService = userService;
        this.profileService = profileService;
    }


    @Override
    public void handle(UpdateUserCommand command) {
        Profile profile = profileService.findById(command.profile());
        User user = new User(command.id(), command.firstName(), command.lastName(),command.identification(), command.email(),
                command.password(), command.type(), command.state(), profile, command.registrationState(),
                command.phone(), false);
        userService.updateUser(user);
    }

}
