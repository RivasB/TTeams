package cloud.tteams.station.station.infrastructure.adapter.query;


import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.location.domain.LocationLatitude;
import cloud.tteams.station.location.domain.LocationLongitude;
import cloud.tteams.station.station.application.StationResponse;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationChargerType;
import cloud.tteams.station.station.domain.StationId;
import cloud.tteams.station.station.domain.StationStatus;
import cloud.tteams.station.station.domain.repository.IStationQueryRepository;
import cloud.tteams.station.station.infrastructure.exception.StationNotFoundException;
import cloud.tteams.station.station.infrastructure.repository.hibernate.StationDto;
import cloud.tteams.station.station.infrastructure.service.GeoDistanceService;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@Primary
public class MysqlDBStationQueryRepository implements IStationQueryRepository {
    private final ISpringStationReadDataJPARepository jpaRepository;

    private final GeoDistanceService geoDistanceService;

    public MysqlDBStationQueryRepository(final ISpringStationReadDataJPARepository jpaRepository, GeoDistanceService geoDistanceService) {
        this.jpaRepository = jpaRepository;
        this.geoDistanceService = geoDistanceService;
    }

    @Override
    public Station findById(StationId id) {
        StationDto stationDto = jpaRepository.findById(id.value())
                .orElseThrow(StationNotFoundException::new);
        return stationDto.toAggregate();
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        Page<StationDto> page = jpaRepository.findAll(pageable);
        return this.result(page);
    }

    @Override
    public Station findByProximity(LocationLatitude latitude, LocationLongitude longitude, StationChargerType vehicleChargerType) {
        Set<StationDto> availableStations = jpaRepository.findByChargerTypeAndStatus(vehicleChargerType,
                StationStatus.AVAILABLE);
        double lat = Double.parseDouble(latitude.getValue());
        double lon = Double.parseDouble(longitude.getValue());
        StationDto close = geoDistanceService.findClosestObject(availableStations,lat,lon);
        return close.toAggregate();
    }


    private MessagePaginatedResponse result(Page<StationDto> page) {
        List<StationResponse> response = page.stream()
                .map(item -> new StationResponse(item.toAggregate())).toList();
        return new MessagePaginatedResponse(response, page);
    }

}
