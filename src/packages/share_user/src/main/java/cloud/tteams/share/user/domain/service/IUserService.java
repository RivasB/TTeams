package cloud.tteams.share.user.domain.service;


import cloud.tteams.share.user.domain.User;
import cloud.tteams.share.user.domain.UserId;
import cloud.tteams.share.user.domain.UserIdentification;

public interface IUserService {

    void createUser(User user);

    void updateUser(User user);

    User findById(UserId id);

    void delete(UserId id);

    User findByIdentification(UserIdentification userIdentification);

    boolean existsById(UserId id);
}
