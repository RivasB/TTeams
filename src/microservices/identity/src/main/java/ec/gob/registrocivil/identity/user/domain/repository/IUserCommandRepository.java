package ec.gob.registrocivil.identity.user.domain.repository;

import java.util.List;

import ec.gob.registrocivil.identity.user.domain.User;

// Repository interface to avoid violate DDD and Clean Arch
public interface IUserCommandRepository {
    public void create(User user);

    public void update(User user);

    public void delete(User user);

    public List<User> findAll();
}
