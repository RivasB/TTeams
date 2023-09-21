package cloud.tteams.identity.user.infrastructure.adapter.query;

import java.util.*;

import cloud.tteams.identity.user.infrastructure.repository.hibernate.UserDto;
import cloud.tteams.identity.user.infrastructure.repository.hibernate.UserSpecs;
import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.exceptions.ResourceNotFoundException;
import cloud.tteams.identity.user.application.UserResponse;
import cloud.tteams.identity.user.domain.User;
import cloud.tteams.identity.user.domain.UserId;
import cloud.tteams.identity.user.domain.repository.IUserQueryRepository;

@Component
@Primary
public class PostgresDBUserQueryRepository implements IUserQueryRepository {

    private final ISpringUserReadDataJPARepository userRepository;

    public PostgresDBUserQueryRepository(final ISpringUserReadDataJPARepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(UserId id) {
        Optional<UserDto> userEntity = userRepository.findById(id.getValue());

        if (!userEntity.isPresent())
            throw new ResourceNotFoundException("User not found.");

        return userEntity.get().toAggregate();
    }

    @Override
    public Optional<User> findByIdentification(String identification) throws ResponseStatusException {
        Optional<UserDto> userEntity = userRepository.findByIdentification(identification);
        if (!userEntity.isPresent()) {
            throw new ResourceNotFoundException("User not found.");
        }
        return Optional.of(userEntity.get().toAggregate());
    }

    @Override
    public MessagePaginatedResponse allUsersWithOutFilter(Pageable pageable) {
        Page<UserDto> usersDto = this.userRepository.findAll(pageable);
        return this.result(usersDto);
    }

    /*
     * Usado por los metodos: allUsersWithOutFilter y allUsersWithFilter
     */
    private MessagePaginatedResponse result(Page<UserDto> usersDto) {
        List<UserResponse> users = new ArrayList<>();
        usersDto.forEach(x -> users.add(new UserResponse(x.toAggregate())));

        return new MessagePaginatedResponse("OK", users, usersDto.getTotalPages(),
                usersDto.getNumberOfElements(), usersDto.getTotalElements(), usersDto.getSize(),
                usersDto.getNumber());
    }

    @Override
    public MessagePaginatedResponse allUsersWithFilter(Pageable pageable, String filter) {

//        List<Specification<UserDto>> specs_and = new ArrayList<>();
//        List<Specification<UserDto>> specs_or = new ArrayList<>();
//
//        if(StringUtils.isNotEmpty(filter)){
//            specs_or.add(UserSpecs.getFirstNameContainingIgnoreCase(first));
//            specs_or.add(UserSpecs.getLastNameContainingIgnoreCase(filter));
//            specs_or.add(UserSpecs.getIdentification(filter));
//            specs_or.add(UserSpecs.getEmail(filter));
//            specs_or.add(UserSpecs.getUserState(UserState.fromName(filter)));
//            specs_or.add(UserSpecs.getUserType(UserType.fromName(filter)));
//
//            specs_and.add(Specification.anyOf(specs_or));
//        }
//
//
//        Page<UserDto> usersDto = this.userRepository.findAll(Specification.allOf(specs_and), pageable);

//        return this.result(usersDto);
        return null;
    }

    @Override
    public Long countByIdentification(String identification) {
        return userRepository.countByIdentification(identification);
    }

    @Override
    public Long countByEmail(String email) {
        return userRepository.countByEmail(email);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Long countByIdIsNotAndEmail(UUID id, String email) {
        return userRepository.countByIdIsNotAndEmail(id, email);
    }

    @Override
    public Long countByIdIsNotAndIdentification(UUID id, String identification) {
        return userRepository.countByIdIsNotAndIdentification(id, identification);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable, String firstName, String lastName, String identification, String email, UserType type, UserState state, String filter) {

        List<Specification<UserDto>> specs_and = new ArrayList<>();


        if(StringUtils.isNotEmpty(firstName)){
            specs_and.add(Specification.anyOf(UserSpecs.getFirstNameContainingIgnoreCase(firstName)));
        }

        if(StringUtils.isNotEmpty(email)){
            specs_and.add(Specification.anyOf(UserSpecs.getEmail(email)));
        }

        if(StringUtils.isNotEmpty(lastName)){
            specs_and.add(Specification.anyOf(UserSpecs.getLastNameContainingIgnoreCase(lastName)));
        }

        if(Objects.nonNull(state)){
            specs_and.add(UserSpecs.getUserState(state));
        }

        if(Objects.nonNull(type)){
            specs_and.add(UserSpecs.getUserType(type));
        }

        Page<UserDto> userDtos = userRepository.findAll(Specification.allOf(specs_and), pageable);
        List<UserResponse> list = new ArrayList<>();

        userDtos.forEach(item -> list.add(new UserResponse(item.toAggregate())));

        return new MessagePaginatedResponse("ok", list, userDtos.getTotalPages(),
                userDtos.getNumberOfElements(), userDtos.getTotalElements(), userDtos.getSize(),
                userDtos.getNumber());
    }
}
