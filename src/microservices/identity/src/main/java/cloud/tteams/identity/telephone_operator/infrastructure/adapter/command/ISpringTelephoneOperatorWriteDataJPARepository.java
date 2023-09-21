package cloud.tteams.identity.telephone_operator.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.identity.telephone_operator.infrastructure.repository.hibernate.TelephoneOperatorDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringTelephoneOperatorWriteDataJPARepository extends JpaRepository<TelephoneOperatorDto, UUID> {

}
