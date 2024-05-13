package cloud.tteams.identity.profile.domain.service;

import org.springframework.data.domain.Pageable;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;

public interface IProfileService {

    void create(Profile profile);

    void update(Profile profile);

    void delete(ProfileId id);

    Profile findById(ProfileId id);

    MessagePaginatedResponse getPaginatedProfiles(Pageable pageable, String filter, ProfileName name,
                                                  ProfileDescription description, ProfileState state,
                                                  AgencyId agencyId);

}
