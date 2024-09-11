package cloud.tteams.identity.user.domain.service;

import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.user.domain.*;
import org.springframework.data.domain.Pageable;

import cloud.tteams.share.core.application.query.MessagePaginatedResponse;

public interface IUserService {

    //Administrative endpoints
    void createUser(User user);

    void updateUser(User user);

    User findById(UUID id);

    MessagePaginatedResponse getPaginatedUsers(Pageable pageable, String firstName, String lastName, String identification, String email, UserType type, UserState state, String filter);

    UUID delete(UUID id);

    User findByEmail(String email);

    Optional<RegistrationToken> registerUser(User user);

    void validateOTP(String otp, String password);

    Long countByIdIsNotAndEmail(UUID id, String mail);

    void changePassword(String identification, String oldPassword, String newPassword);

    void spreadUsers();
    
}
