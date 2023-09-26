package cloud.tteams.identity.agency.infrastructure.repository.hibernate;

import cloud.tteams.identity.agency.domain.AgencyState;
import cloud.tteams.identity.geographiclocation.infrastructure.repository.hibernate.GeographicLocationDto_;
import org.springframework.data.jpa.domain.Specification;

public class AgencySpecs {
    public static Specification<AgencyDto> getNameContainingIgnoreCase(String name){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(AgencyDto_.NAME), "%" + name + "%"));
    }

    public static Specification<AgencyDto> getProvinceContainingIgnoreCase(String province){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(AgencyDto_.PROVINCE),"%" + province + "%" ));
    }

    public static Specification<AgencyDto> getCantonContainingIgnoreCase(String canton){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(AgencyDto_.CANTON).get(GeographicLocationDto_.NAME),
                "%" + canton + "%"));
    }

    public static Specification<AgencyDto> getDescriptionContainingIgnoreCase(String description){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(AgencyDto_.DESCRIPTION),"%" + description + "%" ));
    }

    public static Specification<AgencyDto> getLatitude(String latitude){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(AgencyDto_.LATITUDE),"%" + latitude + "%" ));
    }

    public static Specification<AgencyDto> getLongitude(String longitude){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(AgencyDto_.LONGITUDE),"%" + longitude + "%" ));
    }

    public static Specification<AgencyDto> getState(AgencyState state){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(AgencyDto_.STATE), state));
    }
}
