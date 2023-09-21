package cloud.tteams.identity.user.application.query.validatenuirelationship;

import cloud.tteams.share.core.domain.bus.query.IQuery;
import cloud.tteams.share.middleware.nui.infrastructure.service.RelationshipType;

public class ValidateCitizenNuiRelationShipQuery implements IQuery {
    private String firstNui;
    private String secondNui;
    private RelationshipType relationship;

    public ValidateCitizenNuiRelationShipQuery(String firstNui, String secondNui, RelationshipType relationship) {
        this.firstNui = firstNui;
        this.secondNui = secondNui;
        this.relationship = relationship;
    }

    public static ValidateCitizenNuiRelationShipQuery fromRequest(ValidateCitizenNuiRelationShipRequest request) {
        return new ValidateCitizenNuiRelationShipQuery(
                request.getFirstNui(),
                request.getSecondNui(),
                request.getRelationship()
        );
    }

    public String getFirstNui() {
        return firstNui;
    }

    public String getSecondNui() {
        return secondNui;
    }

    public RelationshipType getRelationship() {
        return relationship;
    }

}
