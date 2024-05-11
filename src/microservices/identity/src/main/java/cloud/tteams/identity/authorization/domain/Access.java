package cloud.tteams.identity.authorization.domain;

public record Access(AccessId id, AccessCode code, AccessDescription description, AccessResourceCode resourceCode) {

}
