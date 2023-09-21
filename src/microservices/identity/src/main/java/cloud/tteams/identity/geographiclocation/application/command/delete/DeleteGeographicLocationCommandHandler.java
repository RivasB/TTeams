package cloud.tteams.identity.geographiclocation.application.command.delete;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationId;
import cloud.tteams.identity.geographiclocation.domain.service.IGeographicLocationService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;

@Component
public class DeleteGeographicLocationCommandHandler implements ICommandHandler<DeleteGeographicLocationCommand> {

    private final IGeographicLocationService geographicLocationService;

    public DeleteGeographicLocationCommandHandler(IGeographicLocationService service) {
        this.geographicLocationService = service;
    }

    @Override
    public void handle(DeleteGeographicLocationCommand command) {
        GeographicLocation location = geographicLocationService.findById(new GeographicLocationId(command.getId()));

        geographicLocationService.delete(location);
    }

}
