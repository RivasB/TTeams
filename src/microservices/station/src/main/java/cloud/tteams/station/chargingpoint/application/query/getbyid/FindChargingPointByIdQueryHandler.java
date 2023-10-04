package cloud.tteams.station.chargingpoint.application.query.getbyid;

import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.station.chargingpoint.application.ChargingPointResponse;
import cloud.tteams.station.chargingpoint.domain.ChargingPoint;
import cloud.tteams.station.chargingpoint.domain.ChargingPointId;
import cloud.tteams.station.chargingpoint.domain.service.IChargingPointService;
import org.springframework.stereotype.Component;

@Component
public class FindChargingPointByIdQueryHandler implements IQueryHandler<FindChargingPointByIdQuery, ChargingPointResponse> {

    private final IChargingPointService chargingPointService;

    public FindChargingPointByIdQueryHandler(IChargingPointService chargingPointService) {
        this.chargingPointService = chargingPointService;
    }

    @Override
    public ChargingPointResponse handle(FindChargingPointByIdQuery query) {
        ChargingPointId id = new ChargingPointId(query.getId());
        ChargingPoint chargingPoint = chargingPointService.findById(id);
        return new ChargingPointResponse(chargingPoint);
    }
}
