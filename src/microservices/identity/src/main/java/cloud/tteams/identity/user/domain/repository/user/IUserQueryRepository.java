package cloud.tteams.identity.user.domain.repository.user;

import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;
import org.springframework.data.domain.Pageable;

import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.identity.user.domain.User;

public interface IUserQueryRepository {

    User findById(UUID id);

    Optional<User> findByEmail(String email);

    Long countByIdIsNotAndEmail(UUID id, String email);

    MessagePaginatedResponse findAll(Pageable pageable, String firstName, String lastName, String identification, String email, UserType type, UserState state, String filter);

    Long countByIdIsNotAndIdentification(UUID id, String identification);
}
