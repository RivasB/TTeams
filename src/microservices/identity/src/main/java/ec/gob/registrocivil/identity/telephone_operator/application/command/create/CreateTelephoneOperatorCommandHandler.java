package ec.gob.registrocivil.identity.telephone_operator.application.command.create;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommandHandler;
import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperator;
import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperatorId;
import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperatorName;
import ec.gob.registrocivil.identity.telephone_operator.domain.service.ITelephoneOperatorService;

@Component
public class CreateTelephoneOperatorCommandHandler implements ICommandHandler<CreateTelephoneOperatorCommand> {

    private ITelephoneOperatorService telephoneOperatorService;

    public CreateTelephoneOperatorCommandHandler(ITelephoneOperatorService telephoneOperatorService) {
        this.telephoneOperatorService = telephoneOperatorService;
    }

    @Override
    public void handle(CreateTelephoneOperatorCommand command) {
        TelephoneOperatorId id = new TelephoneOperatorId(command.getId());
        TelephoneOperatorName name = new TelephoneOperatorName(command.getName());

        TelephoneOperator entity = new TelephoneOperator(id, name);

        telephoneOperatorService.createTelephoneOperator(entity);
    }

}
