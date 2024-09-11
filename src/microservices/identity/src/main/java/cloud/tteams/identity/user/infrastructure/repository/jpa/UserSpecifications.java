package cloud.tteams.identity.user.infrastructure.repository.jpa;

import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;
import cloud.tteams.identity.user.infrastructure.repository.hibernate.UserEntity;
import cloud.tteams.identity.user.infrastructure.repository.hibernate.UserEntity_;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {

    public static Specification<UserEntity> getFirstNameContainingIgnoreCase(String firstName){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(UserEntity_.FIRST_NAME)), "%" + firstName.toLowerCase() + "%"));
    }

    public static Specification<UserEntity> getLastNameContainingIgnoreCase(String lastName){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(UserEntity_.LAST_NAME)), "%" + lastName.toLowerCase() + "%"));
    }

    public static Specification<UserEntity> getIdentification(String identification){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(UserEntity_.IDENTIFICATION), identification));
    }

    public static Specification<UserEntity> getEmail(String email){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(UserEntity_.EMAIL), email));
    }

    public static Specification<UserEntity> getUserState(UserState state){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(UserEntity_.STATE), state));
    }

    public static Specification<UserEntity> getUserType(UserType type){

        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(UserEntity_.TYPE), type));
    }
}
