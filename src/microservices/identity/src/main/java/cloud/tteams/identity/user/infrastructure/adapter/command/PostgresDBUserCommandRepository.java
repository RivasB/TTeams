package cloud.tteams.identity.user.infrastructure.adapter.command;

import java.util.List;

import cloud.tteams.identity.user.infrastructure.repository.hibernate.UserDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.user.domain.User;
import cloud.tteams.identity.user.domain.repository.IUserCommandRepository;

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
        user.delete();
        userRepository.save(new UserDto(user));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream().map(item -> {
            return item.toAggregate();
        }).toList();
    }
}
