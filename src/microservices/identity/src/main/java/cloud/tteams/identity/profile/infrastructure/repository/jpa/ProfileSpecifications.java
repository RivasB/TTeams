package cloud.tteams.identity.profile.infrastructure.repository.jpa;

import cloud.tteams.identity.profile.infrastructure.repository.hibernate.ProfileEntity;
import cloud.tteams.share.core.domain.State;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;


public class ProfileSpecifications {

    public static Specification<ProfileEntity> nameIgnoreCase(String value) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("name")), "%" + value.toLowerCase() + "%");
    }

    public static Specification<ProfileEntity> descriptionIgnoreCase(String value) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("description")), "%" + value.toLowerCase() + "%");
    }

    public static Specification<ProfileEntity> stateEqualTo(State value) {
        return (root, query, cb) -> cb.equal(root.get("state"), value);
    }

    public static Specification<ProfileEntity> organizationIdEqualTo(UUID organization) {
        return (root, query, cb) -> cb.equal(root.get("organization").get("id"), organization);
    }

    public static Specification<ProfileEntity> agencyNameIgnoreCase(String organizationName) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("organization").get("name")), "%" + organizationName.toLowerCase() + "%");
    }

}
