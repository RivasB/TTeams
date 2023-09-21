package cloud.tteams.identity.telephone_operator.application.command.delete;

import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperatorId;
import cloud.tteams.identity.telephone_operator.domain.service.ITelephoneOperatorService;

@Component
public class DeleteTelephoneOperatorCommandHandler implements ICommandHandler<DeleteTelephoneOperatorCommand> {

    private ITelephoneOperatorService telephoneOperatorService;

    public DeleteTelephoneOperatorCommandHandler(ITelephoneOperatorService telephoneOperatorService) {
        this.telephoneOperatorService = telephoneOperatorService;
    }

    @Override
    public void handle(DeleteTelephoneOperatorCommand command) {
        TelephoneOperatorId id = new TelephoneOperatorId(command.getId());

        telephoneOperatorService.deleteTelephoneOperator(id);
    }

}
