package cloud.tteams.identity.user.domain.service;

import java.util.Optional;

import cloud.tteams.identity.user.domain.*;
import org.springframework.data.domain.Pageable;

import cloud.tteams.share.core.application.query.MessagePaginatedResponse;

public interface IUserService {
    public void createUser(User user);

    public void updateUser(User user);

    public User findById(UserId id);

    public MessagePaginatedResponse getPaginatedUsers(Pageable pageable, String firstName, String lastName, String identification, String email, UserType type, UserState state, String filter);

    public UserId delete(UserId id);

    public Long countByIdentification(UserIdentification identification);

    public Long countByEmail(UserEmail email);

    public User findByEmail(UserEmail email);

    public User findByIdentification(UserIdentification userIdentification);

    public Optional<RegistrationToken> registerUser(User user);

    public UserId validateOTP(String otp, String password);

    public Long countByIdIsNotAndEmail(UserId id, UserEmail mail);

    public Long countByIdIsNotAndIdentification(UserId id, UserIdentification identification);

    public void changePassword(UserIdentification identification, UserPassword oldPassword,
            UserPassword newPassword);

    public Optional<RegistrationToken> findByUserId(UserId userId);

    public void spreadUsers();
    
}
