package cloud.tteams.identity.profile.application.command.create;

import java.util.HashSet;

import cloud.tteams.identity.authorization.domain.service.IAuthorizationService;
import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.identity.organization.domain.service.IOrganizationService;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.service.IProfileService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;

@Component
public class CreateProfileCommandHandler implements ICommandHandler<CreateProfileCommand> {

    private final IProfileService profileService;
    private final IOrganizationService agencyService;
    private final IAuthorizationService accessService;

    public CreateProfileCommandHandler(IProfileService profileService, IOrganizationService agencyService,
            IAuthorizationService accessService) {
        this.profileService = profileService;
        this.agencyService = agencyService;
        this.accessService = accessService;
    }

    @Override
    public void handle(CreateProfileCommand command) {
        ProfileId id = new ProfileId(command.getId());
        ProfileName name = new ProfileName(command.getName());
        ProfileDescription description = new ProfileDescription(command.getDescription());
        Organization organization = agencyService.findById(new AgencyId(command.getAgency()));
        ProfileState state = command.getState();
        ProfileAccessSet access = new ProfileAccessSet(new HashSet<>());
        command.getAccess().stream().forEach(element -> {
            Authorization toStore = accessService.findById(new AccessId(element));
            access.getValue().add(toStore);
        });

        Profile profile = new Profile(id, name, description, state, organization, null, access);

        profileService.create(profile);
    }

}
