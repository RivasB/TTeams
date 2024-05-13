package cloud.tteams.identity.profile.infrastructure.adapter.query;

import cloud.tteams.identity.profile.infrastructure.exception.ProfileNotFoundException;
import cloud.tteams.identity.profile.infrastructure.repository.hibernate.ProfileDto;
import cloud.tteams.identity.profile.infrastructure.repository.jpa.ProfileSpecifications;
import cloud.tteams.identity.profile.application.ProfileResponse;
import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.repository.IProfileQueryRepository;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class PostgreDBProfileQueryRepository implements IProfileQueryRepository {

    private final IProfileQueryJPARepository queryJPARepository;

    public PostgreDBProfileQueryRepository(IProfileQueryJPARepository queryJPARepository) {
        this.queryJPARepository = queryJPARepository;
    }

    @Override
    public Profile findById(ProfileId id) {
        return queryJPARepository.findById(id.getValue())
                .map(ProfileDto::toAggregate)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found"));
    }

    @Override
    public MessagePaginatedResponse findAllProfiles(Pageable pageable, String filter, ProfileName name,
                                                    ProfileDescription description, ProfileState state,
                                                    AgencyId agencyId) {
        List<Specification<ProfileDto>> specifications = new ArrayList<>();

        if (filter != null && !filter.isBlank()) {
            Specification<ProfileDto> filterSpec = ProfileSpecifications.nameIgnoreCase(filter)
                    .or(ProfileSpecifications.descriptionIgnoreCase(filter))
                    .or(ProfileSpecifications.agencyNameIgnoreCase(filter));
            specifications.add(filterSpec);
        }
        if (name.value() != null) {
            specifications.add(ProfileSpecifications.nameIgnoreCase(name.value()));
        }
        if (description.value() != null) {
            specifications.add(ProfileSpecifications.descriptionIgnoreCase(description.value()));
        }
        if (state != null) {
            specifications.add(ProfileSpecifications.stateEqualTo(state));
        }
        if (agencyId.value() != null) {
            specifications.add(ProfileSpecifications.agencyIdEqualTo(agencyId.value()));
        }
        Page<ProfileDto> page = queryJPARepository.findAll(Specification.allOf(specifications), pageable);
        List<ProfileResponse> profiles = page.stream().map(p -> new ProfileResponse(p.toAggregate())).toList();
        return new MessagePaginatedResponse("OK", profiles, page.getTotalPages(), page.getNumberOfElements(),
                page.getTotalElements(), page.getSize(), page.getNumber());
    }

}
