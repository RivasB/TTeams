package cloud.tteams.identity.application.application.command.create;

import java.util.HashSet;

import cloud.tteams.identity.authorization.domain.AccessId;
import cloud.tteams.identity.authorization.domain.service.IAccessService;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.application.domain.Aplication;
import cloud.tteams.identity.application.domain.AplicationAccessSet;
import cloud.tteams.identity.application.domain.AplicationDescription;
import cloud.tteams.identity.application.domain.AplicationId;
import cloud.tteams.identity.application.domain.AplicationName;
import cloud.tteams.identity.application.domain.AplicationState;
import cloud.tteams.identity.application.domain.service.IAplicationService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;

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
