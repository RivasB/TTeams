package cloud.tteams.identity.user.application.query.validatenuirelationship;

import cloud.tteams.share.middleware.nui.infrastructure.service.RelationshipType;

public class ValidateCitizenNuiRelationShipRequest {

    private String firstNui;
    private String secondNui;
    private RelationshipType relationship;

    public ValidateCitizenNuiRelationShipRequest() {
    }

    public ValidateCitizenNuiRelationShipRequest(String firstNui, String secondNui, RelationshipType relationship) {
        this.firstNui = firstNui;
        this.secondNui = secondNui;
        this.relationship = relationship;
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
