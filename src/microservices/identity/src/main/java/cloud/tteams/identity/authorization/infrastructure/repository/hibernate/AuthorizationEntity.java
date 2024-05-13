package cloud.tteams.identity.authorization.infrastructure.repository.hibernate;

import cloud.tteams.identity.authorization.domain.*;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.infrastructure.config.annotation.CommandRepository;
import cloud.tteams.share.core.infrastructure.config.annotation.Persistent;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Persistent
@Table(name = "tteams_authorization")
public class AuthorizationEntity {

    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column
    private String resource;

    @Enumerated(EnumType.STRING)
    private AuthorizedAction action;

    @Enumerated(EnumType.STRING)
    private State state;

    public AuthorizationEntity() {
    }


    public AuthorizationEntity(Authorization authorization) {
        this.id = authorization.getId();
        this.name = authorization.getName();
        this.resource = authorization.getResource();
        this.action = authorization.getAction();
        this.state = authorization.getState();
    }

    public Authorization toAggregate() {
        return new Authorization(this.id, this.name, this.resource, this.action, this.state);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getResource() {
        return resource;
    }

    public AuthorizedAction getAction() {
        return action;
    }

    public State getState() {
        return state;
    }
}
