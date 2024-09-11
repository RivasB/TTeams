package cloud.tteams.identity.user.infrastructure.adapter.query.user;

import java.util.*;

import cloud.tteams.identity.user.infrastructure.repository.hibernate.UserEntity;
import cloud.tteams.identity.user.infrastructure.repository.jpa.UserSpecifications;
import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.exceptions.ResourceNotFoundException;
import cloud.tteams.identity.user.application.UserResponse;
import cloud.tteams.identity.user.domain.User;
import cloud.tteams.identity.user.domain.repository.user.IUserQueryRepository;

@Component
@Primary
public class PostgresDBUserQueryRepository implements IUserQueryRepository {

    private final ISpringUserReadDataJPARepository userRepository;

    public PostgresDBUserQueryRepository(final ISpringUserReadDataJPARepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(UUID id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isEmpty())
            throw new ResourceNotFoundException("User not found.");
        return userEntity.get().toAggregate();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Long countByIdIsNotAndEmail(UUID id, String email) {
        return userRepository.countByIdIsNotAndEmail(id, email);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable, String firstName, String lastName, String identification, String email, UserType type, UserState state, String filter) {

        List<Specification<UserEntity>> specs_and = new ArrayList<>();

        if(StringUtils.isNotEmpty(firstName)){
            specs_and.add(Specification.anyOf(UserSpecifications.getFirstNameContainingIgnoreCase(firstName)));
        }

        if(StringUtils.isNotEmpty(identification)){
            specs_and.add(Specification.anyOf(UserSpecifications.getIdentification(identification)));
        }

        if(StringUtils.isNotEmpty(email)){
            specs_and.add(Specification.anyOf(UserSpecifications.getEmail(email)));
        }

        if(StringUtils.isNotEmpty(lastName)){
            specs_and.add(Specification.anyOf(UserSpecifications.getLastNameContainingIgnoreCase(lastName)));
        }

        if(Objects.nonNull(state)){
            specs_and.add(UserSpecifications.getUserState(state));
        }

        if(Objects.nonNull(type)){
            specs_and.add(UserSpecifications.getUserType(type));
        }

        Page<UserEntity> userEntities = userRepository.findAll(Specification.allOf(specs_and), pageable);
        List<UserResponse> list = new ArrayList<>();

        userEntities.forEach(item -> list.add(new UserResponse(item.toAggregate())));

        return new MessagePaginatedResponse("OK", list, userEntities.getTotalPages(),
                userEntities.getNumberOfElements(), userEntities.getTotalElements(), userEntities.getSize(),
                userEntities.getNumber());
    }

    @Override
    public Long countByIdIsNotAndIdentification(UUID id, String identification) {
        return userRepository.countByIdIsNotAndIdentification(id,identification);
    }
}
