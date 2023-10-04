package cloud.tteams.station.station.application.command.delete;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.station.station.domain.StationId;
import cloud.tteams.station.station.domain.service.IStationService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeleteStationCommandHandler implements ICommandHandler<DeleteStationCommand> {

    private final IStationService stationService;

    public DeleteStationCommandHandler(IStationService stationService) {
        this.stationService = stationService;
    }

    @Transactional
    @Override
    public void handle(DeleteStationCommand command) {
        StationId id = new StationId(command.getId());
        stationService.delete(id);
    }
}
