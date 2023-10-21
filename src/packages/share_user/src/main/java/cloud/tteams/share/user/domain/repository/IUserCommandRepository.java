package cloud.tteams.share.user.domain.repository;


import cloud.tteams.share.user.domain.User;

// Repository interface to avoid violate DDD and Clean Arch
public interface IUserCommandRepository {
    void create(User user);

    void update(User user);

    void delete(User user);
}
