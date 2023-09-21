package cloud.tteams.identity.validation_mesh.infrastructure.repository.hibernate;

import java.util.UUID;

import cloud.tteams.identity.validation_mesh.domain.Validation;
import cloud.tteams.identity.validation_mesh.domain.ValidationCondition;
import cloud.tteams.identity.validation_mesh.domain.ValidationDescription;
import cloud.tteams.identity.validation_mesh.domain.ValidationId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpa_validation")
public class ValidationDto {

    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(name = "cedula_condition", nullable = false)
    private String cedulaCondition;

    @Column(name = "can_create_av_account")
    private Boolean canCreateAVAccount;

    @Column(name = "can_change_name")
    private Boolean canChangeName;

    @Column(name = "can_pay_registration_notarial_deed")
    private Boolean canPayRegistrationNotarialDeed;

    @Column(name = "can_pay_validation_of_documents")
    private Boolean canPayValidationOfDocuments;

    public ValidationDto() {
    }

    public ValidationDto(UUID id, String cedulaCondition, Boolean canCreateAVAccount, Boolean canChangeName,
            Boolean canPayRegistrationNotarialDeed, Boolean canPayValidationOfDocuments) {
        this.id = id;
        this.cedulaCondition = cedulaCondition;
        this.canCreateAVAccount = canCreateAVAccount;
        this.canChangeName = canChangeName;
        this.canPayRegistrationNotarialDeed = canPayRegistrationNotarialDeed;
        this.canPayValidationOfDocuments = canPayValidationOfDocuments;
    }

    public ValidationDto(Validation validation) {
        this.id = validation.getId().value();
        this.cedulaCondition = validation.getCedulaCondition().value();
        this.canCreateAVAccount = validation.getCanCreateAVAccount().value();
        this.canChangeName = validation.getCanChangeName().value();
        this.canPayRegistrationNotarialDeed = validation.getCanPayRegistrationNotarialDeed().value();
        this.canPayValidationOfDocuments = validation.getCanPayValidationOfDocuments().value();
    }

    public Validation toAggregate() {
        ValidationId vId = new ValidationId(this.id);
        ValidationDescription vCedulaCondition = new ValidationDescription(this.cedulaCondition);
        ValidationCondition vCanCreateAVAccount = new ValidationCondition(this.canCreateAVAccount);
        ValidationCondition vCanChangeName = new ValidationCondition(this.canChangeName);
        ValidationCondition vCanPayRegistrationNotarialDeed = new ValidationCondition(
                this.canPayRegistrationNotarialDeed);
        ValidationCondition vCanPayValidationOfDocuments = new ValidationCondition(this.canPayValidationOfDocuments);

        return new Validation(vId, vCedulaCondition, vCanCreateAVAccount, vCanChangeName,
                vCanPayRegistrationNotarialDeed,
                vCanPayValidationOfDocuments);
    }

    public UUID getId() {
        return id;
    }

    public String getCedulaCondition() {
        return cedulaCondition;
    }

    public Boolean getCanCreateAVAccount() {
        return canCreateAVAccount;
    }

    public Boolean getCanChangeName() {
        return canChangeName;
    }

    public Boolean getCanPayRegistrationNotarialDeed() {
        return canPayRegistrationNotarialDeed;
    }

    public Boolean getCanPayValidationOfDocuments() {
        return canPayValidationOfDocuments;
    }

}
