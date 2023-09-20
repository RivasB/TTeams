package ec.gob.registrocivil.identity.profile.application.command.create;

import java.util.HashSet;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.access.domain.Access;
import ec.gob.registrocivil.identity.access.domain.AccessId;
import ec.gob.registrocivil.identity.access.domain.service.IAccessService;
import ec.gob.registrocivil.identity.agency.domain.Agency;
import ec.gob.registrocivil.identity.agency.domain.AgencyId;
import ec.gob.registrocivil.identity.agency.domain.service.IAgencyService;
import ec.gob.registrocivil.identity.profile.domain.Profile;
import ec.gob.registrocivil.identity.profile.domain.ProfileAccessSet;
import ec.gob.registrocivil.identity.profile.domain.ProfileDescription;
import ec.gob.registrocivil.identity.profile.domain.ProfileId;
import ec.gob.registrocivil.identity.profile.domain.ProfileName;
import ec.gob.registrocivil.identity.profile.domain.ProfileState;
import ec.gob.registrocivil.identity.profile.domain.service.IProfileService;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandHandler;

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
