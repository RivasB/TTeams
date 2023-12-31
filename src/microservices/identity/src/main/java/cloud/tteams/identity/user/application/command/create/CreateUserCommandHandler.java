package cloud.tteams.identity.user.application.command.create;

import cloud.tteams.identity.profile.domain.ProfileId;
import cloud.tteams.identity.profile.domain.service.IProfileService;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperatorId;
import cloud.tteams.identity.telephone_operator.domain.service.ITelephoneOperatorService;
import cloud.tteams.identity.user.domain.*;
import cloud.tteams.identity.user.domain.*;
import cloud.tteams.identity.user.domain.service.IUserService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.UUID;

@Component
public class CreateUserCommandHandler implements ICommandHandler<CreateUserCommand> {

    private final IUserService userService;
    private final IProfileService profileService;
    private final ITelephoneOperatorService operatorService;

    public CreateUserCommandHandler(
            IUserService userService,
            IProfileService profileService,
            ITelephoneOperatorService operatorService) {

        this.userService = userService;
        this.profileService = profileService;
        this.operatorService = operatorService;
    }

    @Override
    public void handle(CreateUserCommand command) {
        UserId id = new UserId(command.getId());
        UserFirstName firstName = new UserFirstName(command.getFirstName());
        UserLastName lastName = new UserLastName(command.getLastName());
        UserIdentification identification = new UserIdentification(command.getIdentification());
        UserEmail email = new UserEmail(command.getEmail());
        UserPassword password = new UserPassword(command.getPassword());
        UserType type = command.getType();
        UserState state = command.getState();

        UserProfileSet profiles = new UserProfileSet(new HashSet<>());
        if (command.getProfile() != null && command.getType() == UserType.SPECIALIST) {
            command.getProfile().forEach(element -> profiles.getValue()
                    .add(profileService.findById(new ProfileId(UUID.fromString(element)))));
        }

        RegistrationTokenState registrationState = command.getRegistrationState();
        UserPhone phone = null;
        if (command.getPhone() != null) {
            phone = new UserPhone(command.getPhone());
        }

        TelephoneOperator operator = null;
        if (command.getOperator() != null) {
            operator = operatorService.findById(new TelephoneOperatorId(command.getOperator()));
        }

        User user = new User(id, firstName, lastName, identification, email, password, type, state, profiles,
                registrationState, phone, operator);

        userService.createUser(user);
    }
}
