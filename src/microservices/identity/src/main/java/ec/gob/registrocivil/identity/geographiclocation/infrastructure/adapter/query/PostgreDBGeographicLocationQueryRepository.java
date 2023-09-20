package ec.gob.registrocivil.identity.geographiclocation.infrastructure.adapter.query;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.geographiclocation.application.GeographicLocationResponse;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationId;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationType;
import ec.gob.registrocivil.identity.geographiclocation.domain.repository.IGeographicLocationQueryRepository;
import ec.gob.registrocivil.identity.geographiclocation.infrastructure.repository.hibernate.GeographicLocationDto;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;
import ec.gob.registrocivil.share.core.infrastructure.exceptions.ResourceNotFoundException;

@Component
@Primary
public class PostgreDBGeographicLocationQueryRepository implements IGeographicLocationQueryRepository {

    private final IGeographicLocationQueryJPARepository queryJPARepository;

    public PostgreDBGeographicLocationQueryRepository(IGeographicLocationQueryJPARepository queryJPARepository) {
        this.queryJPARepository = queryJPARepository;
    }

    @Override
    public GeographicLocation findById(GeographicLocationId geographicLocationId) {
        Optional<GeographicLocationDto> locationDto = queryJPARepository.findById(geographicLocationId.getValue());
        if (!locationDto.isPresent()) {
            throw new ResourceNotFoundException("Location not found");
        }
        return locationDto.get().toAggregate();
    }

    @Override
    public MessagePaginatedResponse allGeographicLocationWithFilter(Pageable pageable, String filter) {
        Page<GeographicLocationDto> page = queryJPARepository
                .getGeographicLocationDtoByNameContainingIgnoreCase(filter, pageable);
        return this.result(page);
    }

    @Override
    public MessagePaginatedResponse allGeographicLocationWithOutFilter(Pageable pageable) {
        Page<GeographicLocationDto> page = queryJPARepository.findAll(pageable);
        return this.result(page);
    }

    public MessagePaginatedResponse result(Page<GeographicLocationDto> page) {
        List<GeographicLocationResponse> responses = page.stream().map(element -> {
            return new GeographicLocationResponse(element.getId(), element.getName(), element.getType());
        }).toList();
        return new MessagePaginatedResponse("OK", responses, page.getTotalPages(), page.getNumberOfElements(),
                page.getTotalElements(), page.getSize(), page.getNumber());

    }

    @Override
    public MessagePaginatedResponse allLocationsWithFilter(Pageable pageable, String filter,
            GeographicLocationType type) {
        Page<GeographicLocationDto> page = queryJPARepository
                .getGeographicLocationDtoByNameContainingIgnoreCaseAndType(filter, type,
                        pageable);
        return this.result(page);
    }

    @Override
    public MessagePaginatedResponse allLocationsWithOutFilter(Pageable pageable, GeographicLocationType type) {
        Page<GeographicLocationDto> page = queryJPARepository.findAllByType(type, pageable);
        return this.result(page);
    }

    @Override
    public MessagePaginatedResponse findByParent(Pageable pageable, GeographicLocationId parent) {
        Page<GeographicLocationDto> page = queryJPARepository.findByParent(parent.getValue(), pageable);
        return this.result(page);
    }

}
