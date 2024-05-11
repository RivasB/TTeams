package cloud.tteams.identity.organization.infrastructure.adapter.query;

import java.util.*;

import cloud.tteams.identity.organization.application.query.AgencyResponse;
import cloud.tteams.identity.organization.domain.Agency;
import cloud.tteams.identity.organization.domain.AgencyId;
import cloud.tteams.identity.organization.domain.AgencyState;
import cloud.tteams.identity.organization.domain.repository.IAgencyQueryRepository;
import cloud.tteams.identity.organization.infrastructure.repository.hibernate.AgencyDto;
import cloud.tteams.identity.organization.infrastructure.repository.hibernate.AgencySpecs;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationId;
import cloud.tteams.identity.geographiclocation.infrastructure.adapter.query.IGeographicLocationQueryJPARepository;
import cloud.tteams.identity.geographiclocation.infrastructure.repository.hibernate.GeographicLocationDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.DomainException;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;

@Component
@Primary
public class PostgresDBAgencyQueryRepository implements IAgencyQueryRepository {
    private final ISpringAgencyReadDataJPARepository agencyRepository;
    private final IGeographicLocationQueryJPARepository geographicRepository;

    public PostgresDBAgencyQueryRepository(ISpringAgencyReadDataJPARepository agencyRepository,
            IGeographicLocationQueryJPARepository geographicRepository) {
        this.agencyRepository = agencyRepository;
        this.geographicRepository = geographicRepository;
    }

    @Override
    public Agency findById(AgencyId id) {
        Optional<AgencyDto> agencyEntity = agencyRepository.findById(id.getValue());

        if (!agencyEntity.isPresent())
            throw new DomainException("Agency not found.");

        return agencyEntity.get().toAggregate();
    }

    @Override
    public Agency findByName(String name) {
        Optional<AgencyDto> agencyEntity = agencyRepository.findByName(name);

        if (!agencyEntity.isPresent())
            throw new DomainException("Agency not found.");

        return agencyEntity.get().toAggregate();
    }

    @Override
    public MessagePaginatedResponse allAgencyWithOutFilter(Pageable pageable) {
        Page<AgencyDto> usersDto = this.agencyRepository.findAll(pageable);
        return this.result(usersDto);
    }

    private MessagePaginatedResponse result(Page<AgencyDto> agenciesDto) {
        List<AgencyResponse> agencies = new ArrayList<>();
        agenciesDto.forEach(element -> agencies.add(new AgencyResponse(element.toAggregate())));

        return new MessagePaginatedResponse("OK", agencies, agenciesDto.getTotalPages(),
                agenciesDto.getNumberOfElements(), agenciesDto.getTotalElements(), agenciesDto.getSize(),
                agenciesDto.getNumber());
    }

    @Override
    public MessagePaginatedResponse allAgencyWithFilter(Pageable pageable, String filter) {
        Page<AgencyDto> agenciesDto = this.agencyRepository
                .getAgencyDtoByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
                        filter, filter, pageable);

        return this.result(agenciesDto);
    }

    @Override
    public Long countByName(String name) {
        return agencyRepository.countByName(name);
    }

    @Override
    public Long countByIdIsNotAndName(UUID id, String name) {
        return agencyRepository.countByIdIsNotAndName(id, name);
    }

    @Override
    public List<Agency> findAgencyByProvince(GeographicLocationId geographicLocationId) {
        Optional<GeographicLocationDto> province = geographicRepository.findById(geographicLocationId.getValue());
        List<AgencyDto> agencyDtoList = agencyRepository.findAgencyDtoByProvince(province.get());
        return agencyDtoList.stream().map(item -> {
            return item.toAggregate();
        }).toList();
    }

    @Override
    public List<Agency> findAgencyByCanton(GeographicLocationId geographicLocationId) {
        Optional<GeographicLocationDto> canton = geographicRepository.findById(geographicLocationId.getValue());
        List<AgencyDto> agencyDtoList = agencyRepository.findAgencyDtoByCanton(canton.get());
        return agencyDtoList.stream().map(item -> {
            return item.toAggregate();
        }).toList();
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable, String name, String province, String canton, String description, String latitude, String longitude, AgencyState state, String filter) {
        List<Specification<AgencyDto>> specs_and = new ArrayList<>();

        if(StringUtils.isNotEmpty(name)){
            specs_and.add(Specification.anyOf(AgencySpecs.getNameContainingIgnoreCase(name)));
        }

        if(StringUtils.isNotEmpty(province)){
            specs_and.add(Specification.anyOf(AgencySpecs.getProvinceContainingIgnoreCase(province)));
        }

        if(StringUtils.isNotEmpty(canton)){
            specs_and.add(Specification.anyOf(AgencySpecs.getCantonContainingIgnoreCase(canton)));
        }

        if(StringUtils.isNotEmpty(description)){
            specs_and.add(Specification.anyOf(AgencySpecs.getDescriptionContainingIgnoreCase(description)));
        }

        if(StringUtils.isNotEmpty(latitude)){
            specs_and.add(Specification.anyOf(AgencySpecs.getLatitude(latitude)));
        }

        if(StringUtils.isNotEmpty(longitude)){
            specs_and.add(Specification.anyOf(AgencySpecs.getLongitude(longitude)));
        }

        if(Objects.nonNull(state)){
            specs_and.add(Specification.anyOf(AgencySpecs.getState(state)));
        }

        Page<AgencyDto> agencyDtos = agencyRepository.findAll(Specification.allOf(specs_and), pageable);
        List<AgencyResponse> list = new ArrayList<>();

        agencyDtos.forEach(item -> list.add(new AgencyResponse(item.toAggregate())));

        return new MessagePaginatedResponse("ok", list, agencyDtos.getTotalPages(),
                agencyDtos.getNumberOfElements(), agencyDtos.getTotalElements(), agencyDtos.getSize(),
                agencyDtos.getNumber());
    }
}
