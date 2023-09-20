package ec.gob.registrocivil.identity.geographiclocation.application.command.update;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationId;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationName;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationType;
import ec.gob.registrocivil.identity.geographiclocation.domain.service.IGeographicLocationService;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandHandler;

@Component
public class UpdateGeographicLocationCommandHandler implements ICommandHandler<UpdateGeographicLocationCommand> {

    private final IGeographicLocationService service;

    public UpdateGeographicLocationCommandHandler(IGeographicLocationService service) {
        this.service = service;
    }

    @Override
    public void handle(UpdateGeographicLocationCommand command) {
        GeographicLocation toUpdate = service.findById(new GeographicLocationId(command.getId()));

        GeographicLocationName name = command.getName() != null ? new GeographicLocationName(command.getName())
                : toUpdate.getName();
        GeographicLocationType type = command.getType() != null ? command.getType() : toUpdate.getType();
        GeographicLocation parent = command.getParent() != null
                ? service.findById(new GeographicLocationId(command.getParent()))
                : toUpdate.getParent();

        GeographicLocation updated = new GeographicLocation(toUpdate.getId(), name, type, parent);

        service.update(updated);
    }

}
