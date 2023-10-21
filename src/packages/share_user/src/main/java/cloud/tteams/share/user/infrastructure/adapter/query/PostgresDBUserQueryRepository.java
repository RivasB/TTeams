package cloud.tteams.share.user.infrastructure.adapter.query;

import cloud.tteams.share.core.infrastructure.exceptions.ResourceNotFoundException;
import cloud.tteams.share.user.domain.User;
import cloud.tteams.share.user.domain.UserId;
import cloud.tteams.share.user.infrastructure.repository.hibernate.UserDto;
import cloud.tteams.share.user.domain.repository.IUserQueryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class PostgresDBUserQueryRepository implements IUserQueryRepository {

    private final ISpringUserReadDataJPARepository userRepository;

    public PostgresDBUserQueryRepository(final ISpringUserReadDataJPARepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(UserId id) {
        return userRepository.findById(id.getValue())
                .map(UserDto::toAggregate)
                .orElseThrow(() -> new ResourceNotFoundException("User not found."));
    }

    @Override
    public Optional<User> findByIdentification(String identification) {
        return userRepository.findByIdentification(identification).map(UserDto::toAggregate);
    }

    @Override
    public boolean existsById(UserId id) {
        return userRepository.existsById(id.getValue());
    }
}
