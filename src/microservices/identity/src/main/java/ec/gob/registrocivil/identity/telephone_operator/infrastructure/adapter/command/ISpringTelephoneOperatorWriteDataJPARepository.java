package ec.gob.registrocivil.identity.telephone_operator.infrastructure.adapter.command;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.registrocivil.identity.telephone_operator.infrastructure.repository.hibernate.TelephoneOperatorDto;

public interface ISpringTelephoneOperatorWriteDataJPARepository extends JpaRepository<TelephoneOperatorDto, UUID> {

}
