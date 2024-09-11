package cloud.tteams.identity.profile.infrastructure.adapter.query;

import cloud.tteams.identity.profile.infrastructure.exception.ProfileNotFoundException;
import cloud.tteams.identity.profile.infrastructure.repository.hibernate.ProfileEntity;
import cloud.tteams.identity.profile.infrastructure.repository.jpa.ProfileSpecifications;
import cloud.tteams.identity.profile.application.ProfileResponse;
import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.repository.IProfileQueryRepository;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.State;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
@Primary
public class PostgreDBProfileQueryRepository implements IProfileQueryRepository {

    private final IProfileQueryJPARepository queryJPARepository;

    public PostgreDBProfileQueryRepository(IProfileQueryJPARepository queryJPARepository) {
        this.queryJPARepository = queryJPARepository;
    }

    @Override
    public Profile findById(UUID id) {
        return queryJPARepository.findById(id)
                .map(ProfileEntity::toAggregate)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found"));
    }

    @Override
    public MessagePaginatedResponse findAllProfiles(Pageable pageable, String filter, String name,
                                                    String description, State state,
                                                    UUID organization) {
        List<Specification<ProfileEntity>> specifications = new ArrayList<>();

        if (!filter.isBlank()) {
            Specification<ProfileEntity> filterSpec = ProfileSpecifications.nameIgnoreCase(filter)
                    .or(ProfileSpecifications.descriptionIgnoreCase(filter))
                    .or(ProfileSpecifications.agencyNameIgnoreCase(filter));
            specifications.add(filterSpec);
        }
        if (!name.isBlank()) {
            specifications.add(ProfileSpecifications.nameIgnoreCase(name));
        }
        if (!description.isBlank()) {
            specifications.add(ProfileSpecifications.descriptionIgnoreCase(description));
        }
        if (Objects.nonNull(state)) {
            specifications.add(ProfileSpecifications.stateEqualTo(state));
        }
        if (Objects.nonNull(organization)) {
            specifications.add(ProfileSpecifications.organizationIdEqualTo(organization));
        }
        Page<ProfileEntity> page = queryJPARepository.findAll(Specification.allOf(specifications), pageable);
        List<ProfileResponse> profiles = page.stream().map(p -> new ProfileResponse(p.toAggregate())).toList();
        return new MessagePaginatedResponse("OK", profiles, page.getTotalPages(), page.getNumberOfElements(),
                page.getTotalElements(), page.getSize(), page.getNumber());
    }

}
