package cloud.tteams.identity.aplication.application.command.delete;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.aplication.domain.AplicationId;
import cloud.tteams.identity.aplication.domain.service.IAplicationService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;

@Component
public class DeleteApplicationCommandHandler implements ICommandHandler<DeleteApplicatinCommand> {

    private final IAplicationService applicationService;

    public DeleteApplicationCommandHandler(IAplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Override
    public void handle(DeleteApplicatinCommand command) {
        AplicationId id = new AplicationId(command.getId());

        applicationService.delete(id);
    }

}
