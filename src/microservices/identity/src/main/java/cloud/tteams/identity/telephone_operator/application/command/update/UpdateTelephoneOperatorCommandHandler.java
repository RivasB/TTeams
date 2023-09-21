package cloud.tteams.identity.telephone_operator.application.command.update;

import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperatorId;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperatorName;
import cloud.tteams.identity.telephone_operator.domain.service.ITelephoneOperatorService;

@Component
public class UpdateTelephoneOperatorCommandHandler implements ICommandHandler<UpdateTelephoneOperatorCommand> {

    private ITelephoneOperatorService telephoneOperatorService;

    public UpdateTelephoneOperatorCommandHandler(ITelephoneOperatorService telephoneOperatorService) {
        this.telephoneOperatorService = telephoneOperatorService;
    }

    @Override
    public void handle(UpdateTelephoneOperatorCommand command) {
        TelephoneOperatorId id = new TelephoneOperatorId(command.getId());
        TelephoneOperatorName name = new TelephoneOperatorName(command.getName());

        TelephoneOperator entity = new TelephoneOperator(id, name);

        telephoneOperatorService.updateTelephoneOperator(entity);
    }

}
