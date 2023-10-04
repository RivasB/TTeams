package cloud.tteams.station.chargingpoint.application.command.update;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.station.chargingpoint.domain.ChargingPoint;
import cloud.tteams.station.chargingpoint.domain.ChargingPointId;
import cloud.tteams.station.chargingpoint.domain.ChargingPointPowerLevel;
import cloud.tteams.station.chargingpoint.domain.service.IChargingPointService;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationId;
import cloud.tteams.station.station.domain.service.IStationService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdateChargingPointCommandHandler implements ICommandHandler<UpdateChargingPointCommand> {

    private final IStationService stationService;

    private final IChargingPointService chargingPointService;

    public UpdateChargingPointCommandHandler(IStationService stationService, IChargingPointService chargingPointService) {
        this.stationService = stationService;
        this.chargingPointService = chargingPointService;
    }

    @Transactional
    @Override
    public void handle(UpdateChargingPointCommand command) {
        StationId stationId = new StationId(command.getStation());
        Station station = stationService.findById(stationId);
        ChargingPointId id = new ChargingPointId(command.getId());
        ChargingPointPowerLevel powerLevel = new ChargingPointPowerLevel(command.getPowerLevel());
        ChargingPoint chargingPoint = new ChargingPoint(id, powerLevel,station);
        chargingPointService.update(chargingPoint);
    }
}
