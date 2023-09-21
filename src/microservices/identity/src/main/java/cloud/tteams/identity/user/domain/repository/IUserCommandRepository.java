package cloud.tteams.identity.user.domain.repository;

import java.util.List;

import cloud.tteams.identity.user.domain.User;

// Repository interface to avoid violate DDD and Clean Arch
public interface IUserCommandRepository {
    public void create(User user);

    public void update(User user);

    public void delete(User user);

    public List<User> findAll();
}
