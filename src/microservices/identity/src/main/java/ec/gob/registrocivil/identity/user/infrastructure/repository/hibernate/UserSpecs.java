package ec.gob.registrocivil.identity.user.infrastructure.repository.hibernate;

import ec.gob.registrocivil.identity.user.domain.UserState;
import ec.gob.registrocivil.identity.user.domain.UserType;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecs {

    public static Specification<UserDto> getFirstNameContainingIgnoreCase(String firstName){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(UserDto_.FIRST_NAME)), "%" + firstName.toLowerCase() + "%"));
    }

    public static Specification<UserDto> getLastNameContainingIgnoreCase(String lastName){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(UserDto_.LAST_NAME)), "%" + lastName.toLowerCase() + "%"));
    }

    public static Specification<UserDto> getIdentification(String identification){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(UserDto_.IDENTIFICATION), identification));
    }

    public static Specification<UserDto> getEmail(String email){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(UserDto_.EMAIL), email));
    }

    public static Specification<UserDto> getUserState(UserState state){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(UserDto_.STATE), state));
    }

    public static Specification<UserDto> getUserType(UserType type){

        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(UserDto_.TYPE), type));
    }
}
