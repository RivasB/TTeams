package cloud.tteams.identity.profile.domain.service;

import cloud.tteams.share.core.domain.State;
import org.springframework.data.domain.Pageable;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;

import java.util.UUID;

public interface IProfileService {

    void create(Profile profile);

    void update(Profile profile);

    void delete(UUID id);

    Profile findById(UUID id);

    MessagePaginatedResponse getPaginatedProfiles(Pageable pageable, String filter, String name,
                                                  String description, State state, UUID organization);

}
