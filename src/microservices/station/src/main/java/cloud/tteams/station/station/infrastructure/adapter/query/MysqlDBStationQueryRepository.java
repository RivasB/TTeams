package cloud.tteams.identity.access.infrastructure.adapter.query;

import cloud.tteams.identity.access.infrastructure.exception.StationNotFoundException;
import cloud.tteams.identity.access.infrastructure.repository.hibernate.AccessDto;
import cloud.tteams.identity.access.infrastructure.repository.hibernate.AccessSpecs;
import cloud.tteams.identity.access.application.StationResponse;
import cloud.tteams.identity.access.domain.Station;
import cloud.tteams.identity.access.domain.AccessId;
import cloud.tteams.identity.access.domain.repository.IStationQueryRepository;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.jpa.domain.Specification;

@Component
@Primary
public class MysqlDBStationQueryRepository implements IStationQueryRepository {
    private final ISpringStationReadDataJPARepository accessRepository;

    public MysqlDBStationQueryRepository(final ISpringStationReadDataJPARepository accessRepository) {
        this.accessRepository = accessRepository;
    }

    @Override
    public Optional<Station> findById(AccessId id) {
        AccessDto accessEntity = accessRepository.findById(id.value()).orElseThrow(StationNotFoundException::new);

        return Optional.of(accessEntity.toAggregate());
    }

    @Override
    public MessagePaginatedResponse allAccessWithOutFilter(Pageable pageable) {
        Page<AccessDto> accessDtoPage = accessRepository.findAll(pageable);
        return this.result(accessDtoPage);
    }

    @Override
    public MessagePaginatedResponse allAccessWithFilter(Pageable pageable, String filter) {
        Page<AccessDto> page = accessRepository
                .getAccessDtoByCodeContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
                        filter, filter, pageable);

        return this.result(page);
    }

    @Override
    public Optional<Station> findByCode(String code) {
        AccessDto accessEntity = accessRepository.findByCode(code);

        return Optional.of(accessEntity.toAggregate());
    }

    /*
     * Usado por los metodos: allAccessWithOutFilter y allAccessWithFilter
     */
    private MessagePaginatedResponse result(Page<AccessDto> accessDtoPage) {
        List<StationResponse> responses = new ArrayList<>();

        accessDtoPage.forEach(
                v -> responses.add(new StationResponse(v.getId(), v.getCode(), v.getDescription(), v.getResourceCode())));

        return new MessagePaginatedResponse("OK", responses, accessDtoPage.getTotalPages(),
                accessDtoPage.getNumberOfElements(), accessDtoPage.getTotalElements(), accessDtoPage.getSize(),
                accessDtoPage.getNumber());
    }

    @Override
    public Long countByIdIsNotAndCode(UUID id, String code) {
        return accessRepository.countByIdIsNotAndCode(id, code);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable, String description, String code, String resource) {
        List<Specification<AccessDto>> specs_and = new ArrayList<>();
        
        if(StringUtils.isNotEmpty(description)){
            specs_and.add(Specification.anyOf(AccessSpecs.getDescriptionContainingIgnoreCase(description)));
        }
        
        if(StringUtils.isNotEmpty(code)){
            specs_and.add(Specification.anyOf(AccessSpecs.getCodeContainingIgnoreCase(code)));
        }
        
        if(StringUtils.isNotEmpty(resource)){
            specs_and.add(Specification.anyOf(AccessSpecs.getResourceContainingIgnoreCase(resource)));
        }
        
        Page<AccessDto> accessDtos = accessRepository.findAll(Specification.allOf(specs_and), pageable);
        List<StationResponse> access = new ArrayList<>();
        
        accessDtos.forEach(item -> access.add(new StationResponse(item.toAggregate())));
        return new MessagePaginatedResponse("OK", access, accessDtos.getTotalPages(),
                accessDtos.getNumberOfElements(), accessDtos.getTotalElements(), accessDtos.getSize(),
                accessDtos.getNumber());
    }

}
