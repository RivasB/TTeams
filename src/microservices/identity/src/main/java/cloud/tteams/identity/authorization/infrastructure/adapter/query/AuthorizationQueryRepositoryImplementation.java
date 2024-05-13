package cloud.tteams.identity.authorization.infrastructure.adapter.query;

import cloud.tteams.identity.authorization.domain.Authorization;
import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import cloud.tteams.identity.authorization.infrastructure.exception.AuthorizationNotFoundException;
import cloud.tteams.identity.authorization.infrastructure.repository.hibernate.AuthorizationEntity;
import cloud.tteams.identity.authorization.infrastructure.repository.jpa.AuthorizationSpecification;
import cloud.tteams.identity.authorization.application.AuthorizationResponse;
import cloud.tteams.identity.authorization.domain.repository.IAuthorizationQueryRepository;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.State;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.domain.Specification;

@Component
@Primary
public class AuthorizationQueryRepositoryImplementation implements IAuthorizationQueryRepository {
    private final IAuthorizationQueryJPARepository repository;

    public AuthorizationQueryRepositoryImplementation(final IAuthorizationQueryJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public Authorization findById(UUID id) {
        AuthorizationEntity authorizationEntity = repository.findById(id).orElseThrow(AuthorizationNotFoundException::new);
        return authorizationEntity.toAggregate();
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable, String name, String resource, AuthorizedAction action, State state) {
        List<Specification<AuthorizationEntity>> specs_and = new ArrayList<>();
        if(StringUtils.isNotEmpty(name)){
            specs_and.add(Specification.anyOf(AuthorizationSpecification.getNameContainingIgnoreCase(name)));
        }
        if(StringUtils.isNotEmpty(resource)){
            specs_and.add(Specification.anyOf(AuthorizationSpecification.getResourceContainingIgnoreCase(resource)));
        }
        if(Objects.nonNull(action)){
            specs_and.add(Specification.anyOf(AuthorizationSpecification.getAction(action)));
        }
        if(Objects.nonNull(state)){
            specs_and.add(Specification.anyOf(AuthorizationSpecification.getState(state)));
        }
        Page<AuthorizationEntity> authorizationEntities = repository.findAll(Specification.allOf(specs_and), pageable);
        List<AuthorizationResponse> authorizations = new ArrayList<>();
        
        authorizationEntities.forEach(item -> authorizations.add(new AuthorizationResponse(item.toAggregate())));
        return new MessagePaginatedResponse("OK", authorizations, authorizationEntities.getTotalPages(),
                authorizationEntities.getNumberOfElements(), authorizationEntities.getTotalElements(), authorizationEntities.getSize(),
                authorizationEntities.getNumber());
    }

}
