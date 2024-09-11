package cloud.tteams.identity.profile.domain.repository;

import cloud.tteams.share.core.domain.State;
import org.springframework.data.domain.Pageable;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;

import java.util.UUID;

public interface IProfileQueryRepository {

    Profile findById(UUID id);

    MessagePaginatedResponse findAllProfiles(Pageable pageable, String filter, String name,
                                             String description, State state,
                                             UUID organization);

}
