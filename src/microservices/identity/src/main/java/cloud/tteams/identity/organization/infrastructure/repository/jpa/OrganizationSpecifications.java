package cloud.tteams.identity.organization.infrastructure.repository.jpa;
import cloud.tteams.identity.organization.infrastructure.repository.hibernate.OrganizationEntity;
import cloud.tteams.share.core.domain.State;
import org.springframework.data.jpa.domain.Specification;

public class OrganizationSpecifications {

    public static Specification<OrganizationEntity> getNameContainingIgnoreCase(String name){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%"));
    }

    public static Specification<OrganizationEntity> getDescriptionContainingIgnoreCase(String description){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("description"),"%" + description + "%" ));
    }

    public static Specification<OrganizationEntity> getContactContainingIgnoreCase(String contact){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("contact"),"%" + contact + "%" ));
    }

    public static Specification<OrganizationEntity> getState(State state){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("state"), state));
    }
}
