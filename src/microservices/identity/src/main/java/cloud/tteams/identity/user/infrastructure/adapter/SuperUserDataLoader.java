package cloud.tteams.identity.user.infrastructure.adapter;

import cloud.tteams.identity.authorization.domain.Authorization;
import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import cloud.tteams.identity.authorization.domain.service.IAuthorizationService;
import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.identity.organization.domain.service.IOrganizationService;
import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.service.IProfileService;
import cloud.tteams.identity.user.domain.RegistrationTokenState;
import cloud.tteams.identity.user.domain.User;
import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;
import cloud.tteams.identity.user.domain.service.IUserService;
import cloud.tteams.share.core.domain.State;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Primary
@Component
public class SuperUserDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final IUserService userService;

    private final IOrganizationService organizationService;

    private final IProfileService profileService;

    private final IAuthorizationService authorizationService;

    public static final String USER_PROFILE_UUID = "3fa85f64-5717-4562-b3fc-2c963f66afa6";

    public SuperUserDataLoader(IUserService userService, IOrganizationService organizationService, IProfileService profileService, IAuthorizationService authorizationService) {
        this.userService = userService;
        this.organizationService = organizationService;
        this.profileService = profileService;
        this.authorizationService = authorizationService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            User administrador = userService.findByEmail("admin@devminds.com");
        }
        catch (Exception ignored) {
            createSuperUserIfNotExist();
        }
    }


    @Transactional
    public void createSuperUserIfNotExist() {
        Organization devminds = this.createOrganizationIfNotExist();
        List<Authorization> adminAuthorizations = this.createAdminAuthorizations();
        Profile adminProfile = this.createProfileIfNotExist(devminds, adminAuthorizations);
        User administrador = new User(UUID.randomUUID(),
                "David Alejandro",
                "Rivas Bori",
                "89021836005",
                "admin@devminds.com",
                "DevMinds*2024",
                UserType.ADMIN,
                UserState.ACTIVE,
                adminProfile,
                RegistrationTokenState.VERIFICATION_ACCEPTED,
                "+5351663448",
                false);
        userService.createUser(administrador);
    }

    private Profile createProfileIfNotExist(Organization devminds, List<Authorization> adminAuthorizations) {
        UUID uuid = UUID.randomUUID();
        Profile profile = new Profile(uuid,
                "Administrador",
                "Perfil Administrador en DevMinds",
                devminds,
                State.ACTIVE,
                adminAuthorizations);
        profileService.create(profile);
        Profile user = new Profile(UUID.fromString(USER_PROFILE_UUID),
                "Desarrollador",
                "Perfil Desarrollador en DevMinds",
                devminds,
                State.ACTIVE,
                this.createUserAuthorizations());
        profileService.create(user);
        return profileService.findById(uuid);
    }

    private List<Authorization> createAdminAuthorizations() {
        UUID createUuid = UUID.randomUUID();
        Authorization all = new Authorization(createUuid, 
                "Administrativos", 
                "**/**", 
                AuthorizedAction.ALL, 
                State.ACTIVE);
        authorizationService.create(all);
        return List.of(authorizationService.findById(createUuid));
    }

    private List<Authorization> createUserAuthorizations() {
        UUID createUuid = UUID.randomUUID();
        Authorization all = new Authorization(createUuid,
                "Desarrollo",
                "/",
                AuthorizedAction.ALL,
                State.ACTIVE);
        authorizationService.create(all);
        return List.of(authorizationService.findById(createUuid));
    }

    private Organization createOrganizationIfNotExist() {
        UUID uuid = UUID.randomUUID();
        Organization devminds = new Organization(uuid,
                "DevMinds", 
                "Empresa de desarrollo de software a la medida",
                "email: contact@devminds.com", 
                State.ACTIVE);
        organizationService.create(devminds);
        return organizationService.findById(uuid);
    }
}
