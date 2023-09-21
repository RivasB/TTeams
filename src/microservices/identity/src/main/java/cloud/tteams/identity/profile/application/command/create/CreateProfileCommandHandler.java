package cloud.tteams.identity.profile.application.command.create;

import java.util.HashSet;

import cloud.tteams.identity.access.domain.Access;
import cloud.tteams.identity.access.domain.AccessId;
import cloud.tteams.identity.access.domain.service.IAccessService;
import cloud.tteams.identity.agency.domain.Agency;
import cloud.tteams.identity.agency.domain.AgencyId;
import cloud.tteams.identity.agency.domain.service.IAgencyService;
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
public class CreateProfileCommandHandler implements ICommandHandler<CreateProfileCommand> {

    private final IProfileService profileService;
    private final IAgencyService agencyService;
    private final IAccessService accessService;

    public CreateProfileCommandHandler(IProfileService profileService, IAgencyService agencyService,
            IAccessService accessService) {
        this.profileService = profileService;
        this.agencyService = agencyService;
        this.accessService = accessService;
    }

    @Override
    public void handle(CreateProfileCommand command) {
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

        profileService.create(profile);
    }

}
