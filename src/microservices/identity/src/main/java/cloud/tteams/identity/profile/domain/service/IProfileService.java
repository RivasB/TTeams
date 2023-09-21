package cloud.tteams.identity.profile.domain.service;

import cloud.tteams.identity.agency.domain.AgencyId;
import cloud.tteams.identity.profile.domain.ProfileDescription;
import cloud.tteams.identity.profile.domain.ProfileName;
import cloud.tteams.identity.profile.domain.ProfileState;
import org.springframework.data.domain.Pageable;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.ProfileId;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;

public interface IProfileService {

    void create(Profile profile);

    void update(Profile profile);

    void delete(ProfileId id);

    Profile findById(ProfileId id);

    MessagePaginatedResponse getPaginatedProfiles(Pageable pageable, String filter, ProfileName name,
                                                  ProfileDescription description, ProfileState state,
                                                  AgencyId agencyId);

}
