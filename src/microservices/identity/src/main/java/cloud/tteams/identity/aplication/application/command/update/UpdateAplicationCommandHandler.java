package cloud.tteams.identity.aplication.application.command.update;

import java.util.Collection;

import cloud.tteams.identity.access.domain.Access;
import cloud.tteams.identity.access.domain.AccessId;
import cloud.tteams.identity.access.domain.service.IAccessService;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.aplication.domain.Aplication;
import cloud.tteams.identity.aplication.domain.AplicationAccessSet;
import cloud.tteams.identity.aplication.domain.AplicationDescription;
import cloud.tteams.identity.aplication.domain.AplicationId;
import cloud.tteams.identity.aplication.domain.AplicationName;
import cloud.tteams.identity.aplication.domain.AplicationState;
import cloud.tteams.identity.aplication.domain.service.IAplicationService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;

@Component
public class UpdateAplicationCommandHandler implements ICommandHandler<UpdateAplicationCommand> {

    private final IAplicationService aplicationService;

    private final IAccessService accessService;

    public UpdateAplicationCommandHandler(IAplicationService aplicationService, IAccessService accessService) {
        this.aplicationService = aplicationService;
        this.accessService = accessService;
    }

    @Override
    public void handle(UpdateAplicationCommand command) {
        AplicationId id = new AplicationId(command.getId());
        AplicationName name = new AplicationName(command.getName());
        AplicationDescription description = new AplicationDescription(command.getDescription());
        AplicationState state = command.getState();

        Collection<Access> rawAccess = command.getAccess().stream()
                .map(accessId -> accessService.findById(new AccessId(accessId))).toList();

        AplicationAccessSet access = new AplicationAccessSet(rawAccess);

        Aplication aplicationSave = new Aplication(id, name, description, state, access);

        aplicationService.updateAplication(aplicationSave);
    }
}
