package cloud.tteams.identity.user.domain.repository;

import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;
import org.springframework.data.domain.Pageable;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.identity.user.domain.User;
import cloud.tteams.identity.user.domain.UserId;

// Repository interface to avoid violate DDD and Clean Arch
public interface IUserQueryRepository {
    public User findById(UserId id);

    public Optional<User> findByIdentification(String identification);

    public MessagePaginatedResponse allUsersWithOutFilter(Pageable pageable);

    public MessagePaginatedResponse allUsersWithFilter(Pageable pageable, String filter);

    public Long countByIdentification(String identification);

    public User findByEmail(String email);

    public Long countByEmail(String email);

    public Long countByIdIsNotAndEmail(UUID id, String email);

    public Long countByIdIsNotAndIdentification(UUID id, String identification);

    MessagePaginatedResponse findAll(Pageable pageable, String firstName, String lastName, String identification, String email, UserType type, UserState state, String filter);
}
