package ec.gob.registrocivil.identity.profile.domain.service;

import ec.gob.registrocivil.identity.agency.domain.AgencyId;
import ec.gob.registrocivil.identity.profile.domain.ProfileDescription;
import ec.gob.registrocivil.identity.profile.domain.ProfileName;
import ec.gob.registrocivil.identity.profile.domain.ProfileState;
import org.springframework.data.domain.Pageable;

import ec.gob.registrocivil.identity.profile.domain.Profile;
import ec.gob.registrocivil.identity.profile.domain.ProfileId;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;

public interface IProfileService {

    void create(Profile profile);

    void update(Profile profile);

    void delete(ProfileId id);

    Profile findById(ProfileId id);

    MessagePaginatedResponse getPaginatedProfiles(Pageable pageable, String filter, ProfileName name,
                                                  ProfileDescription description, ProfileState state,
                                                  AgencyId agencyId);

}
