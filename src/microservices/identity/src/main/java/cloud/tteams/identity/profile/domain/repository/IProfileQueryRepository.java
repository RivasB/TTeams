package cloud.tteams.identity.profile.domain.repository;

import org.springframework.data.domain.Pageable;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;

public interface IProfileQueryRepository {

    Profile findById(ProfileId id);

    MessagePaginatedResponse findAllProfiles(Pageable pageable, String filter, ProfileName name,
                                             ProfileDescription description, ProfileState state,
                                             AgencyId agencyId);

}
