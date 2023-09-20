package ec.gob.registrocivil.identity.profile.application.query.getbyid;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.profile.domain.Profile;
import ec.gob.registrocivil.identity.profile.domain.ProfileId;
import ec.gob.registrocivil.identity.profile.domain.service.IProfileService;
import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;

@Component
public class FindProfileByIdQueryHandler
        implements IQueryHandler<FindProfileByIdQuery, FindProfileByIdResponse> {

    private final IProfileService profileService;

    public FindProfileByIdQueryHandler(IProfileService profileService) {
        this.profileService = profileService;
    }

    @Override
    public FindProfileByIdResponse handle(FindProfileByIdQuery query) {

        ProfileId id = new ProfileId(query.getId());
        Profile profile = profileService.findById(id);

        return new FindProfileByIdResponse(profile);
    }

}
