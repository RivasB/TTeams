package ec.gob.registrocivil.identity.geographiclocation.application.command.create;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationId;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationName;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationType;
import ec.gob.registrocivil.identity.geographiclocation.domain.service.IGeographicLocationService;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandHandler;

@Component
public class CreateGeographicLocationCommandHandler implements ICommandHandler<CreateGeographicLocationCommand> {

    private final IGeographicLocationService service;

    public CreateGeographicLocationCommandHandler(IGeographicLocationService service) {
        this.service = service;
    }

    @Override
    public void handle(CreateGeographicLocationCommand command) {
        GeographicLocationId id = new GeographicLocationId(command.getId());
        GeographicLocationName name = new GeographicLocationName(command.getName());
        GeographicLocationType type = command.getType();
        GeographicLocation parent = command.getParent() != null
                ? service.findById(new GeographicLocationId(command.getParent()))
                : null;

        GeographicLocation location = new GeographicLocation(id, name, type, parent);

        service.create(location);
    }

}
