package ec.gob.registrocivil.identity.telephone_operator.infrastructure.adapter.command;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperator;
import ec.gob.registrocivil.identity.telephone_operator.domain.repository.ITelephoneOperatorCommandRepository;
import ec.gob.registrocivil.identity.telephone_operator.infrastructure.repository.hibernate.TelephoneOperatorDto;

@Component
@Primary
public class PostgresDBTelephoneOperatorCommandRepository implements ITelephoneOperatorCommandRepository {

    private final ISpringTelephoneOperatorWriteDataJPARepository telephoneOperatorRepository;

    public PostgresDBTelephoneOperatorCommandRepository(
            ISpringTelephoneOperatorWriteDataJPARepository telephoneOperatorRepository) {
        this.telephoneOperatorRepository = telephoneOperatorRepository;
    }

    @Override
    public void create(TelephoneOperator operator) {
        telephoneOperatorRepository.save(new TelephoneOperatorDto(operator));
    }

    @Override
    public void update(TelephoneOperator operator) {
        telephoneOperatorRepository.save(new TelephoneOperatorDto(operator));
    }

    @Override
    public void delete(TelephoneOperator operator) {
        telephoneOperatorRepository.delete(new TelephoneOperatorDto(operator));
    }

}
