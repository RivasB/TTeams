package cloud.tteams.identity.user.infrastructure.adapter;

import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;
import cloud.tteams.identity.user.domain.*;
import cloud.tteams.identity.user.domain.*;
import cloud.tteams.identity.user.domain.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.UUID;

@Component
public class SuperUserDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final IUserService userService;

    private boolean isAdminUserCreated;

    public SuperUserDataLoader(IUserService userService) {
        this.userService = userService;
        this.isAdminUserCreated = (userService.countByIdentification(new UserIdentification("0000000000")) > 0);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (!isAdminUserCreated) {
            createSuperUserIfNotExist();
        }
    }

    @Transactional
    public void createSuperUserIfNotExist() {
        UserId id = new UserId(UUID.randomUUID());
        UserFirstName firstName = new UserFirstName("Super Administrador");
        UserLastName lastName = new UserLastName("del Sistema");
        UserIdentification identification = new UserIdentification("0000000000");
        UserEmail email = new UserEmail("admin@identity.local");
        UserPassword password = new UserPassword("Password*777");
        UserProfileSet profile = new UserProfileSet(new HashSet<>());
        UserPhone phone = new UserPhone("+579 000000");
        TelephoneOperator operator = null;

        User user = new User(id, firstName, lastName, identification, email, password, UserType.CITIZEN,
                UserState.ACTIVE, profile, RegistrationTokenState.VERIFICATION_ACCEPTED, phone,
                operator);

        userService.createUser(user);
    }
}
