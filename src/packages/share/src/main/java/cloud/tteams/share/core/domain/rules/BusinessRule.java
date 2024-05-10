package cloud.tteams.share.core.domain.rules;


public abstract class BusinessRule {

    private final String message;

    protected BusinessRule(String message) {
        this.message = message;
    }

    public abstract boolean isBroken();

    public String getMessage() {
        return message;
    }
}
