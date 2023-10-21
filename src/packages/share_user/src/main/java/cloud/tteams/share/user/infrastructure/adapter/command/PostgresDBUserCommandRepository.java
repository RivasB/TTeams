package cloud.tteams.share.user.infrastructure.adapter.command;

import cloud.tteams.share.user.domain.User;
import cloud.tteams.share.user.domain.repository.IUserCommandRepository;
import cloud.tteams.share.user.infrastructure.repository.hibernate.UserDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Primary
public class PostgresDBUserCommandRepository implements IUserCommandRepository {

    private final ISpringUserWriteDataJPARepository userRepository;

    public PostgresDBUserCommandRepository(final ISpringUserWriteDataJPARepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(new UserDto(user));
    }

    @Override
    public void update(User user) {
        userRepository.save(new UserDto(user));
    }

    @Override
    public void delete(User user) {
        userRepository.delete(new UserDto(user));
    }
}
