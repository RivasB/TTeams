package cloud.tteams.identity.profile.application.query.getbyid;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.service.IProfileService;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

@Component
public class FindProfileByIdQueryHandler
        implements IQueryHandler<FindProfileByIdQuery, FindProfileByIdResponse> {

    private final IProfileService profileService;

    public FindProfileByIdQueryHandler(IProfileService profileService) {
        this.profileService = profileService;
    }

    @Override
    public FindProfileByIdResponse handle(FindProfileByIdQuery query) {
        Profile profile = profileService.findById(query.id());
        return new FindProfileByIdResponse(profile);
    }

}
