package cloud.tteams.identity.profile.domain.repository;

import cloud.tteams.identity.organization.domain.AgencyId;
import cloud.tteams.identity.profile.domain.ProfileDescription;
import cloud.tteams.identity.profile.domain.ProfileName;
import cloud.tteams.identity.profile.domain.ProfileState;
import org.springframework.data.domain.Pageable;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.ProfileId;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;

public interface IProfileQueryRepository {

    Profile findById(ProfileId id);

    MessagePaginatedResponse findAllProfiles(Pageable pageable, String filter, ProfileName name,
                                             ProfileDescription description, ProfileState state,
                                             AgencyId agencyId);

}
