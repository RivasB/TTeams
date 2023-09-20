package ec.gob.registrocivil.identity.user.infrastructure.adapter.command;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.user.domain.User;
import ec.gob.registrocivil.identity.user.domain.repository.IUserCommandRepository;
import ec.gob.registrocivil.identity.user.infrastructure.repository.hibernate.UserDto;

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
