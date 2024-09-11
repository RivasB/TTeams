package cloud.tteams.identity.user.application.command.create;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.service.IProfileService;
import cloud.tteams.identity.user.domain.*;
import cloud.tteams.identity.user.domain.service.IUserService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

@Component
public class CreateUserCommandHandler implements ICommandHandler<CreateUserCommand> {

    private final IUserService userService;
    private final IProfileService profileService;

    public CreateUserCommandHandler(IUserService userService, IProfileService profileService) {
        this.userService = userService;
        this.profileService = profileService;
    }

    @Override
    public void handle(CreateUserCommand command) {
        Profile profile = profileService.findById(command.getProfile());
        User user = new User(command.getId(), command.getFirstName(), command.getLastName(),command.getIdentification(), command.getEmail(),
                command.getPassword(), command.getType(), command.getState(), profile, command.getRegistrationState(),
                command.getPhone(), false);
        userService.createUser(user);
    }
}
