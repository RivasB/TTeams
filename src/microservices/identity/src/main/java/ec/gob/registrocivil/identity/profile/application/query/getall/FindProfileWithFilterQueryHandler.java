package ec.gob.registrocivil.identity.profile.application.query.getall;

import ec.gob.registrocivil.identity.agency.domain.AgencyId;
import ec.gob.registrocivil.identity.profile.domain.ProfileDescription;
import ec.gob.registrocivil.identity.profile.domain.ProfileName;
import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.profile.domain.service.IProfileService;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;
import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;

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
