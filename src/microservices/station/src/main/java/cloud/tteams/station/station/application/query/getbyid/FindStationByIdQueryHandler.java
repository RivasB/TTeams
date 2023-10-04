package cloud.tteams.station.station.application.query.getbyid;

import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.station.station.application.StationResponse;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationId;
import cloud.tteams.station.station.domain.service.IStationService;
import org.springframework.stereotype.Component;

@Component
public class FindStationByIdQueryHandler implements IQueryHandler<FindStationByIdQuery, StationResponse> {

    private final IStationService stationService;

    public FindStationByIdQueryHandler(IStationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public StationResponse handle(FindStationByIdQuery query) {
        StationId id = new StationId(query.getId());
        Station station = stationService.findById(id);
        return new StationResponse(station);
    }
}
