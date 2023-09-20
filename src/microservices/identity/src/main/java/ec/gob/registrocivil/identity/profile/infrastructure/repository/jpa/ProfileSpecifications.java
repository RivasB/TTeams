package ec.gob.registrocivil.identity.profile.infrastructure.repository.jpa;

import ec.gob.registrocivil.identity.agency.infrastructure.repository.hibernate.AgencyDto_;
import ec.gob.registrocivil.identity.profile.domain.ProfileState;
import ec.gob.registrocivil.identity.profile.infrastructure.repository.hibernate.ProfileDto;
import ec.gob.registrocivil.identity.profile.infrastructure.repository.hibernate.ProfileDto_;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;


public class ProfileSpecifications {

    public static Specification<ProfileDto> nameIgnoreCase(String value) {
        return (root, query, cb) -> cb.like(cb.lower(root.get(ProfileDto_.name)), "%" + value.toLowerCase() + "%");
    }

    public static Specification<ProfileDto> descriptionIgnoreCase(String value) {
        return (root, query, cb) -> cb.like(cb.lower(root.get(ProfileDto_.description)), "%" + value.toLowerCase() + "%");
    }

    public static Specification<ProfileDto> stateEqualTo(ProfileState value) {
        return (root, query, cb) -> cb.equal(root.get(ProfileDto_.state), value);
    }

    public static Specification<ProfileDto> agencyIdEqualTo(UUID agencyId) {
        return (root, query, cb) -> cb.equal(root.get(ProfileDto_.agency).get(AgencyDto_.id), agencyId);
    }

    public static Specification<ProfileDto> agencyNameIgnoreCase(String agencyName) {
        return (root, query, cb) -> cb.like(cb.lower(root.get(ProfileDto_.agency).get(AgencyDto_.name)), "%" + agencyName.toLowerCase() + "%");
    }

}
