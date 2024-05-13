package cloud.tteams.identity.authorization.infrastructure.repository.jpa;

import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import cloud.tteams.identity.authorization.infrastructure.repository.hibernate.AccessDto_;
import cloud.tteams.identity.authorization.infrastructure.repository.hibernate.AuthorizationEntity;
import cloud.tteams.share.core.domain.State;
import org.springframework.data.jpa.domain.Specification;

public class AuthorizationSpecification {

    public static Specification<AuthorizationEntity> getNameContainingIgnoreCase(String name){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
                "%" + name.toLowerCase() + "%"));
    }

    public static Specification<AuthorizationEntity> getResourceContainingIgnoreCase(String resource){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(AccessDto_.RESOURCE_CODE)), "%" + resource.toLowerCase() + "%"));
    }

    public static Specification<AuthorizationEntity> getAction(AuthorizedAction action){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("action"), action));
    }

    public static Specification<AuthorizationEntity> getState(State state){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("state"), state));
    }

}
