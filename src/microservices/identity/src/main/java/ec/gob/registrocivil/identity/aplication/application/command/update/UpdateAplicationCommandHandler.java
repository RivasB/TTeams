package ec.gob.registrocivil.identity.aplication.application.command.update;

import java.util.Collection;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.access.domain.Access;
import ec.gob.registrocivil.identity.access.domain.AccessId;
import ec.gob.registrocivil.identity.access.domain.service.IAccessService;
import ec.gob.registrocivil.identity.aplication.domain.Aplication;
import ec.gob.registrocivil.identity.aplication.domain.AplicationAccessSet;
import ec.gob.registrocivil.identity.aplication.domain.AplicationDescription;
import ec.gob.registrocivil.identity.aplication.domain.AplicationId;
import ec.gob.registrocivil.identity.aplication.domain.AplicationName;
import ec.gob.registrocivil.identity.aplication.domain.AplicationState;
import ec.gob.registrocivil.identity.aplication.domain.service.IAplicationService;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandHandler;

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
