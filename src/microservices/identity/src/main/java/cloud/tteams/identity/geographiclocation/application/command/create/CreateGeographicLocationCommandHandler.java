package cloud.tteams.identity.geographiclocation.application.command.create;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationId;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationName;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationType;
import cloud.tteams.identity.geographiclocation.domain.service.IGeographicLocationService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;

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
