package cloud.tteams.station.station.infrastructure.repository.hibernate;

import cloud.tteams.identity.access.infrastructure.repository.hibernate.AccessDto_;
import org.springframework.data.jpa.domain.Specification;

public class StationSpecs {

    public static Specification<StationDto> getDescriptionContainingIgnoreCase(String description){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(AccessDto_.DESCRIPTION)), "%" + description.toLowerCase() + "%"));
    }

    public static Specification<StationDto> getCodeContainingIgnoreCase(String code){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(AccessDto_.CODE)), "%" + code.toLowerCase() + "%"));
    }

    public static Specification<StationDto> getResourceContainingIgnoreCase(String resource){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(AccessDto_.RESOURCE_CODE)), "%" + resource.toLowerCase() + "%"));
    }

}
