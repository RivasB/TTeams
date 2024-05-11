package cloud.tteams.identity.organization.infrastructure.adapter.query;

import java.util.*;

import cloud.tteams.identity.organization.application.query.OrganizationResponse;
import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.identity.organization.domain.repository.IOrganizationQueryRepository;
import cloud.tteams.identity.organization.infrastructure.exception.OrganizationNotFoundException;
import cloud.tteams.identity.organization.infrastructure.repository.hibernate.OrganizationEntity;
import cloud.tteams.identity.organization.infrastructure.repository.jpa.OrganizationSpecifications;
import cloud.tteams.share.core.domain.State;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;

@Component
@Primary
public class OrganizationQueryRepositoryImplementation implements IOrganizationQueryRepository {
    private final IOrganizationQueryJPARepository queryJPARepository;

    public OrganizationQueryRepositoryImplementation(IOrganizationQueryJPARepository queryJPARepository) {
        this.queryJPARepository = queryJPARepository;
    }

    @Override
    public Organization findById(UUID id) {
        OrganizationEntity entity = queryJPARepository.findById(id).orElseThrow(OrganizationNotFoundException::new);
        return entity.toAggregate();
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable, String name, String description, String contact,
                                            State state) {
        List<Specification<OrganizationEntity>> specs_and = new ArrayList<>();
        if(StringUtils.isNotEmpty(name)){
            specs_and.add(Specification.anyOf(OrganizationSpecifications.getNameContainingIgnoreCase(name)));
        }
        if(StringUtils.isNotEmpty(description)){
            specs_and.add(Specification.anyOf(OrganizationSpecifications.getDescriptionContainingIgnoreCase(description)));
        }
        if(StringUtils.isNotEmpty(contact)){
            specs_and.add(Specification.anyOf(OrganizationSpecifications.getContactContainingIgnoreCase(contact)));
        }
        if(Objects.nonNull(state)){
            specs_and.add(Specification.anyOf(OrganizationSpecifications.getState(state)));
        }
        Page<OrganizationEntity> organizationEntities = queryJPARepository.findAll(Specification.allOf(specs_and), pageable);
        List<OrganizationResponse> list = new ArrayList<>();
        organizationEntities.forEach(item -> list.add(new OrganizationResponse(item.toAggregate())));
        return new MessagePaginatedResponse("ok", list, organizationEntities.getTotalPages(),
                organizationEntities.getNumberOfElements(), organizationEntities.getTotalElements(), organizationEntities.getSize(),
                organizationEntities.getNumber());
    }
}
