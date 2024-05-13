package cloud.tteams.identity.profile.application.query.getall;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.profile.domain.service.IProfileService;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

@Component
public class FindProfileWithFilterQueryHandler
        implements IQueryHandler<FindProfileWithFilterQuery, MessagePaginatedResponse> {

    private final IProfileService profileService;

    public FindProfileWithFilterQueryHandler(IProfileService profileService) {
        this.profileService = profileService;
    }

    @Override
    public MessagePaginatedResponse handle(FindProfileWithFilterQuery query) {
        ProfileName name = new ProfileName(query.getName());
        ProfileDescription description = new ProfileDescription(query.getDescription());
        AgencyId agencyId = new AgencyId(query.getAgencyId());
        return profileService.getPaginatedProfiles(query.getPageable(), query.getFilter(), name, description,
                query.getState(), agencyId);
    }

}
