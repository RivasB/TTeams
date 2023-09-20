package ec.gob.registrocivil.identity.user.application.command.update;

import ec.gob.registrocivil.identity.profile.domain.ProfileId;
import ec.gob.registrocivil.identity.profile.domain.service.IProfileService;
import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperator;
import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperatorId;
import ec.gob.registrocivil.identity.telephone_operator.domain.service.ITelephoneOperatorService;
import ec.gob.registrocivil.identity.user.domain.*;
import ec.gob.registrocivil.identity.user.domain.service.IUserService;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandHandler;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class UpdateUserCommandHandler implements ICommandHandler<UpdateUserCommand> {

    private final IUserService userService;
    private final IProfileService profileService;
    private final ITelephoneOperatorService operatorService;

    public UpdateUserCommandHandler(IUserService userService, IProfileService profileService,
            ITelephoneOperatorService operatorService) {

        this.userService = userService;
        this.profileService = profileService;
        this.operatorService = operatorService;
    }

    @Override
    public void handle(UpdateUserCommand command) {
        UserId id = new UserId(command.getId());
        UserFirstName firstName = new UserFirstName(command.getFirstName());
        UserLastName lastName = new UserLastName(command.getLastName());
        UserIdentification identification = new UserIdentification(command.getIdentification());
        UserEmail email = new UserEmail(command.getEmail());
        UserType type = command.getType();
        UserState state = command.getState();

        UserProfileSet profiles = new UserProfileSet(new HashSet<>());
        if (command.getProfile() != null && command.getType() == UserType.SPECIALIST) {
            profiles = new UserProfileSet(command.getProfile().stream()
                    .map(profile -> profileService.findById(new ProfileId(profile)))
                    .collect(Collectors.toSet()));
        }

        // The password must be changed in its own method
        UserPassword password = null;

        // The RegistrationTokenState must be changed in its own method
        RegistrationTokenState registrationState = null;

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

        userService.updateUser(user);
    }

}
