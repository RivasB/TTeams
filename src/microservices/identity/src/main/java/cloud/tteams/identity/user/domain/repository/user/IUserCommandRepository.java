package cloud.tteams.identity.user.domain.repository.user;

import java.util.List;

import cloud.tteams.identity.user.domain.User;

// Repository interface to avoid violate DDD and Clean Arch
public interface IUserCommandRepository {

    void create(User user);

    void update(User user);

    void delete(User user);

    List<User> findAll();
}
