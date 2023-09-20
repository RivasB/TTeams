package ec.gob.registrocivil.identity.validation_mesh.infrastructure.repository.hibernate;

import java.util.UUID;

import ec.gob.registrocivil.identity.validation_mesh.domain.Validation;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByService;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByServiceId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationCivilStatus;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationCondition;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationDescription;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationServiceType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpa_validation_by_service")
public class ValidationByServiceDto {

    @Id
    @Column(nullable = false)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "validation_id", referencedColumnName = "id")
    private ValidationDto validation;

    @Enumerated(EnumType.STRING)
    @Column(name = "service_type")
    private ValidationServiceType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "civil_status")
    private ValidationCivilStatus status;

    @Column(name = "can_request_birth")
    private Boolean canRequestBirth;

    @Column(name = "can_request_marriage")
    private Boolean canRequestMarriage;

    @Column(name = "can_request_death")
    private Boolean canRequestDeath;

    @Column(name = "can_request_de_facto_union")
    private Boolean canRequestDeFactoUnion;

    @Column(name = "can_request_identity_and_civil_status")
    private Boolean canRequestIdentityAndCivilStatus;

    public ValidationByServiceDto() {
    }

    public ValidationByServiceDto(UUID id, ValidationDto validation, ValidationServiceType type,
            ValidationCivilStatus status, Boolean canRequestBirth, Boolean canRequestMarriage, Boolean canRequestDeath,
            Boolean canRequestDeFactoUnion) {
        this.id = id;
        this.validation = validation;
        this.type = type;
        this.status = status;
        this.canRequestBirth = canRequestBirth;
        this.canRequestMarriage = canRequestMarriage;
        this.canRequestDeath = canRequestDeath;
        this.canRequestDeFactoUnion = canRequestDeFactoUnion;
        this.canRequestIdentityAndCivilStatus = null;
    }

    public ValidationByServiceDto(UUID id, ValidationDto validation, ValidationServiceType type,
            ValidationCivilStatus status, Boolean canRequestBirth, Boolean canRequestMarriage, Boolean canRequestDeath,
            Boolean canRequestDeFactoUnion, Boolean canRequestIdentityAndCivilStatus) {
        this.id = id;
        this.validation = validation;
        this.type = type;
        this.status = status;
        this.canRequestBirth = canRequestBirth;
        this.canRequestMarriage = canRequestMarriage;
        this.canRequestDeath = canRequestDeath;
        this.canRequestDeFactoUnion = canRequestDeFactoUnion;
        this.canRequestIdentityAndCivilStatus = canRequestIdentityAndCivilStatus;
    }

    public ValidationByServiceDto(ValidationByService validation) {
        this.id = validation.getId().value();
        this.validation = new ValidationDto(validation.getValidation());
        this.type = validation.getType();
        this.status = validation.getStatus();
        this.canRequestBirth = validation.getCanRequestBirth().value();
        this.canRequestMarriage = validation.getCanRequestMarriage().value();
        this.canRequestDeath = validation.getCanRequestDeath().value();
        this.canRequestDeFactoUnion = validation.getCanRequestDeFactoUnion().value();
        this.canRequestIdentityAndCivilStatus = null;

        if (validation.getCanRequestIdentityAndCivilStatus() != null)
            this.canRequestIdentityAndCivilStatus = validation.getCanRequestIdentityAndCivilStatus().value();
    }

    public ValidationByService toAggregate() {
        ValidationId validationId = new ValidationId(this.validation.getId());
        ValidationDescription validationCedulaCondition = new ValidationDescription(
                this.validation.getCedulaCondition());
        ValidationCondition validationCanCreateAVAccount = new ValidationCondition(
                this.validation.getCanCreateAVAccount());
        ValidationCondition validationCanChangeName = new ValidationCondition(this.validation.getCanChangeName());
        ValidationCondition validationCanPayRegistrationNotarialDeed = new ValidationCondition(
                this.validation.getCanPayRegistrationNotarialDeed());
        ValidationCondition validationCanPayValidationOfDocuments = new ValidationCondition(
                this.validation.getCanPayValidationOfDocuments());

        ValidationByServiceId vId = new ValidationByServiceId(this.id);
        Validation vValidation = new Validation(validationId, validationCedulaCondition, validationCanCreateAVAccount,
                validationCanChangeName, validationCanPayRegistrationNotarialDeed,
                validationCanPayValidationOfDocuments);
        ValidationServiceType vType = this.type;
        ValidationCivilStatus vStatus = this.status;
        ValidationCondition vCanRequestBirth = new ValidationCondition(this.canRequestBirth);
        ValidationCondition vCanRequestMarriage = new ValidationCondition(this.canRequestMarriage);
        ValidationCondition vCanRequestDeath = new ValidationCondition(this.canRequestDeath);
        ValidationCondition vCanRequestDeFactoUnion = new ValidationCondition(this.canRequestDeFactoUnion);
        ValidationCondition vCanRequestIdentityAndCivilStatus = null;

        if (this.canRequestIdentityAndCivilStatus != null)
            vCanRequestIdentityAndCivilStatus = new ValidationCondition(this.canRequestIdentityAndCivilStatus);

        return new ValidationByService(vId, vValidation, vType, vStatus, vCanRequestBirth, vCanRequestMarriage,
                vCanRequestDeath, vCanRequestDeFactoUnion, vCanRequestIdentityAndCivilStatus);
    }

    public UUID getId() {
        return id;
    }

    public ValidationDto getValidation() {
        return validation;
    }

    public ValidationServiceType getType() {
        return type;
    }

    public ValidationCivilStatus getStatus() {
        return status;
    }

    public Boolean getCanRequestBirth() {
        return canRequestBirth;
    }

    public Boolean getCanRequestMarriage() {
        return canRequestMarriage;
    }

    public Boolean getCanRequestDeath() {
        return canRequestDeath;
    }

    public Boolean getCanRequestDeFactoUnion() {
        return canRequestDeFactoUnion;
    }

    public Boolean getCanRequestIdentityAndCivilStatus() {
        return canRequestIdentityAndCivilStatus;
    }

}
