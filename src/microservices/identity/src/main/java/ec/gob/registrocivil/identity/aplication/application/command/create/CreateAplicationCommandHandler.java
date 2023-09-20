package ec.gob.registrocivil.identity.aplication.application.command.create;

import java.util.HashSet;

import org.springframework.stereotype.Component;

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
public class CreateAplicationCommandHandler implements ICommandHandler<CreateAplicationCommand> {

    private final IAplicationService aplicationService;
    private final IAccessService accessService;

    public CreateAplicationCommandHandler(IAplicationService aplicationService, IAccessService accessService) {
        this.aplicationService = aplicationService;
        this.accessService = accessService;
    }

    @Override
    public void handle(CreateAplicationCommand command) {
        AplicationId id = new AplicationId(command.getId());
        AplicationName name = new AplicationName(command.getName());
        AplicationDescription description = new AplicationDescription(command.getDescription());
        AplicationState state = command.getState();

        AplicationAccessSet access = new AplicationAccessSet(new HashSet<>());
        if (command.getAccess() != null) {
            command.getAccess().stream().forEach(
                    element -> access.getValue().add(accessService.findById(new AccessId(element))));
        }

        Aplication aplication = new Aplication(id, name, description, state, access);

        aplicationService.createAplication(aplication);
    }

}
