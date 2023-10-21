package cloud.tteams.share.user.domain.repository;



import cloud.tteams.share.user.domain.User;
import cloud.tteams.share.user.domain.UserId;

import java.util.Optional;

// Repository interface to avoid violate DDD and Clean Arch
public interface IUserQueryRepository {
    User findById(UserId id);

    Optional<User> findByIdentification(String identification);

    boolean existsById(UserId id);
}
