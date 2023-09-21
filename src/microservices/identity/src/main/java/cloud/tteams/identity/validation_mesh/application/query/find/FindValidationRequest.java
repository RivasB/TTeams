package cloud.tteams.identity.validation_mesh.application.query.find;

public class FindValidationRequest {

    private String cedulaCondition;

    public FindValidationRequest(String cedulaCondition) {
        this.cedulaCondition = cedulaCondition;
    }

    public String getCedulaCondition() {
        return cedulaCondition;
    }

}
