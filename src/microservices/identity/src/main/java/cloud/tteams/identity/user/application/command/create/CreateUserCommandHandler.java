package cloud.tteams.identity.user.application.command.create;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.service.IProfileService;
import cloud.tteams.identity.user.domain.*;
import cloud.tteams.identity.user.domain.service.IUserService;
import cloud.tteams.identity.user.infrastructure.adapter.SuperUserDataLoader;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserCommandHandler implements ICommandHandler<CreateUserCommand> {

    private static final Logger log = LoggerFactory.getLogger(CreateUserCommandHandler.class);
    private final IUserService userService;
    private final IProfileService profileService;

    public CreateUserCommandHandler(IUserService userService, IProfileService profileService) {
        this.userService = userService;
        this.profileService = profileService;
    }

    @Override
    public void handle(CreateUserCommand command) {
        try {
            Profile profile = profileService.findById(UUID.fromString(SuperUserDataLoader.USER_PROFILE_UUID));
            User user = new User(command.getId(), command.getFirstName(), command.getLastName(),command.getIdentification(), command.getEmail(),
                    command.getPassword(), command.getType(), command.getState(), profile, command.getRegistrationState(),
                    command.getPhone(), false);
            userService.createUser(user);
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }
}
