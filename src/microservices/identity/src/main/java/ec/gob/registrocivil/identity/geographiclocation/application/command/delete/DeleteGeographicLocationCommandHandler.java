package ec.gob.registrocivil.identity.geographiclocation.application.command.delete;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationId;
import ec.gob.registrocivil.identity.geographiclocation.domain.service.IGeographicLocationService;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandHandler;

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
