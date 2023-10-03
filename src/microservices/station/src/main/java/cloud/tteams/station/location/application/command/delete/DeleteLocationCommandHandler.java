package cloud.tteams.station.location.application.command.delete;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.station.location.domain.LocationId;
import cloud.tteams.station.location.domain.service.ILocationService;
import org.springframework.stereotype.Component;

@Component
public class DeleteLocationCommandHandler implements ICommandHandler<DeleteLocationCommand> {

    private final ILocationService locationService;

    public DeleteLocationCommandHandler(ILocationService locationService) {
        this.locationService = locationService;
    }

    @Override
    public void handle(DeleteLocationCommand command) {
        LocationId id = new LocationId(command.getId());
        locationService.delete(id);
    }
}
