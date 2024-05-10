package cloud.tteams.identity.user.application.command.register.data;

import cloud.tteams.identity.shared.infrastructure.utils.OTPUtil;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperatorId;
import cloud.tteams.identity.telephone_operator.domain.service.ITelephoneOperatorService;
import cloud.tteams.identity.user.domain.*;
import cloud.tteams.identity.user.domain.*;
import cloud.tteams.identity.user.domain.service.IUserService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.share.email.domain.service.IEmailServiceClient;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;

@Component
public class RegisterCitizenCommandHandler implements ICommandHandler<RegisterCitizenCommand> {

    private final IUserService userService;
    private final ITelephoneOperatorService telephoneOperatorService;
    private final IEmailServiceClient mailService;

    public RegisterCitizenCommandHandler(IUserService userService, ITelephoneOperatorService telephoneOperatorService, IEmailServiceClient mailService) {
        this.userService = userService;
        this.telephoneOperatorService = telephoneOperatorService;
        this.mailService = mailService;
    }

    @Override
    public void handle(RegisterCitizenCommand command) {

        UserId id = new UserId(command.getId());
        UserFirstName firstName = new UserFirstName(command.getFirstName());
        UserLastName lastName = new UserLastName(command.getLastName());
        UserIdentification identification = new UserIdentification(command.getNui());
        UserEmail email = new UserEmail(command.getEmail());
        // Encode random password
        UserPassword password = new UserPassword(OTPUtil.genPassword());

        UserProfileSet profiles = new UserProfileSet(new HashSet<>());

        UserPhone phone = new UserPhone(command.getPhone());
        TelephoneOperator operator = telephoneOperatorService
                .findById(new TelephoneOperatorId(command.getTelephoneOperator()));

        UserShouldChangePassword shouldChangePassword = new UserShouldChangePassword(false);

        User newUser = new User(id, firstName, lastName, identification, email, password, UserType.CITIZEN,
                UserState.ACTIVE, profiles, RegistrationTokenState.VERIFICATION_PENDING, phone,
                operator, shouldChangePassword);

        Optional<RegistrationToken> token = userService.registerUser(newUser);
        if(token.isPresent()){
            mailService.sendSimpleEmail(newUser.getEmail().value(), "Registered Successfully", "Pleased to confirm code: " + token.get().getOtp().getValue());
            command.setPhone(token.get().getOtp().getValue());
        }
    }

}
