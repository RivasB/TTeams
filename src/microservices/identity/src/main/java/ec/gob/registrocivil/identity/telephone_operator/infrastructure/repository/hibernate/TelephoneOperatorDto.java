package ec.gob.registrocivil.identity.telephone_operator.infrastructure.repository.hibernate;

import java.util.UUID;

import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperator;
import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperatorId;
import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperatorName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpa_telephone_operator")
public class TelephoneOperatorDto {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public TelephoneOperatorDto() {
    }

    public TelephoneOperatorDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public TelephoneOperatorDto(TelephoneOperator operator) {
        this.id = operator.getId().value();
        this.name = operator.getName().value();
    }

    public TelephoneOperator toAggregate() {
        TelephoneOperatorId eId = new TelephoneOperatorId(this.id);
        TelephoneOperatorName eName = new TelephoneOperatorName(this.name);

        return new TelephoneOperator(eId, eName);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
