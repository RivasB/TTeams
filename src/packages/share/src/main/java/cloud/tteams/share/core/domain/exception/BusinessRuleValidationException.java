package cloud.tteams.share.core.domain.exception;

import cloud.tteams.share.core.domain.rules.BusinessRule;

public class BusinessRuleValidationException extends RuntimeException {

    private final BusinessRule brokenRule;
    private final String message;

    public BusinessRuleValidationException(BusinessRule brokenRule) {
        super(brokenRule.getMessage());

        this.brokenRule = brokenRule;
        this.message = brokenRule.getMessage();
    }

    public BusinessRule getBrokenRule() {
        return brokenRule;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", brokenRule.getClass().getName(), this.getMessage());
    }
}
