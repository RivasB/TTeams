package cloud.tteams.identity.profile.application.command.update;

import java.util.HashSet;

import cloud.tteams.identity.authorization.domain.Access;
import cloud.tteams.identity.authorization.domain.AccessId;
import cloud.tteams.identity.authorization.domain.service.IAccessService;
import cloud.tteams.identity.organization.domain.Agency;
import cloud.tteams.identity.organization.domain.AgencyId;
import cloud.tteams.identity.organization.domain.service.IAgencyService;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.ProfileAccessSet;
import cloud.tteams.identity.profile.domain.ProfileDescription;
import cloud.tteams.identity.profile.domain.ProfileId;
import cloud.tteams.identity.profile.domain.ProfileName;
import cloud.tteams.identity.profile.domain.ProfileState;
import cloud.tteams.identity.profile.domain.service.IProfileService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;

@Component
public class UpdateProfileCommandHandler implements ICommandHandler<UpdateProfileCommand> {

    private final IProfileService profileService;
    private final IAgencyService agencyService;
    private final IAccessService accessService;

    public UpdateProfileCommandHandler(IProfileService profileService, IAgencyService agencyService,
            IAccessService accessService) {
        this.profileService = profileService;
        this.agencyService = agencyService;
        this.accessService = accessService;
    }

    @Override
    public void handle(UpdateProfileCommand command) {
        ProfileId id = new ProfileId(command.getId());
        ProfileName name = new ProfileName(command.getName());
        ProfileDescription description = new ProfileDescription(command.getDescription());
        Agency agency = agencyService.findById(new AgencyId(command.getAgency()));
        ProfileState state = command.getState();
        ProfileAccessSet access = new ProfileAccessSet(new HashSet<>());
        command.getAccess().stream().forEach(element -> {
            Access toStore = accessService.findById(new AccessId(element));
            access.getValue().add(toStore);
        });

        Profile profile = new Profile(id, name, description, state, agency, null, access);

        profileService.update(profile);
    }

}
