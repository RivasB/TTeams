package cloud.tteams.station.chargingpoint.application.command.delete;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.station.chargingpoint.domain.ChargingPointId;
import cloud.tteams.station.chargingpoint.domain.service.IChargingPointService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeleteChargingPointCommandHandler implements ICommandHandler<DeleteChargingPointCommand> {

    private final IChargingPointService chargingPointService;

    public DeleteChargingPointCommandHandler(IChargingPointService chargingPointService) {
        this.chargingPointService = chargingPointService;
    }

    @Transactional
    @Override
    public void handle(DeleteChargingPointCommand command) {
        ChargingPointId id = new ChargingPointId(command.getId());
        chargingPointService.delete(id);
    }
}
