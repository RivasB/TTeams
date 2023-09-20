package ec.gob.registrocivil.identity.access.infrastructure.repository.hibernate;

import ec.gob.registrocivil.identity.access.domain.Access;
import ec.gob.registrocivil.identity.access.domain.AccessCode;
import ec.gob.registrocivil.identity.access.domain.AccessDescription;
import ec.gob.registrocivil.identity.access.domain.AccessId;
import ec.gob.registrocivil.identity.access.domain.AccessResourceCode;
import ec.gob.registrocivil.identity.profile.infrastructure.repository.hibernate.ProfileDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "jpa_access")
public class AccessDto {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "resource_code")
    private String resourceCode;

    @ManyToMany(mappedBy = "access", fetch = FetchType.LAZY)
    private Set<ProfileDto> profiles = new HashSet<>();

    public AccessDto() {
    }

    public AccessDto(Access access) {
        this.id = access.getId().value();
        this.code = access.getCode().value();
        this.resourceCode = access.getResourceCode().value();
        this.description = access.getDescription().value();
    }

    public Access toAggregate() {
        AccessId accessId = new AccessId(id);
        AccessCode accessCode = new AccessCode(code);
        AccessDescription accessDescription = new AccessDescription(description);
        AccessResourceCode accessResourceCode = new AccessResourceCode(resourceCode);
        return new Access(accessId, accessCode, accessDescription, accessResourceCode);
    }

    public UUID getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getResourceCode() {
        return resourceCode;
    }

}
