package cloud.tteams.station.station.infrastructure.repository.hibernate;

import cloud.tteams.identity.access.domain.Access;
import cloud.tteams.identity.access.domain.AccessCode;
import cloud.tteams.identity.access.domain.AccessDescription;
import cloud.tteams.identity.access.domain.AccessId;
import cloud.tteams.identity.access.domain.AccessResourceCode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
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
        this.id = access.id().value();
        this.code = access.code().value();
        this.resourceCode = access.resourceCode().value();
        this.description = access.description().value();
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
