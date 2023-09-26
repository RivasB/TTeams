package cloud.tteams.station.station.infrastructure.repository.hibernate;

import cloud.tteams.identity.access.infrastructure.repository.hibernate.AccessDto_;
import org.springframework.data.jpa.domain.Specification;

public class AccessSpecs {

    public static Specification<AccessDto> getDescriptionContainingIgnoreCase(String description){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(AccessDto_.DESCRIPTION)), "%" + description.toLowerCase() + "%"));
    }

    public static Specification<AccessDto> getCodeContainingIgnoreCase(String code){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(AccessDto_.CODE)), "%" + code.toLowerCase() + "%"));
    }

    public static Specification<AccessDto> getResourceContainingIgnoreCase(String resource){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(AccessDto_.RESOURCE_CODE)), "%" + resource.toLowerCase() + "%"));
    }

}
