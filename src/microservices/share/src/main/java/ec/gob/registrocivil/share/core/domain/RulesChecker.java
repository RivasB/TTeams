package ec.gob.registrocivil.share.core.domain;

import ec.gob.registrocivil.share.core.domain.exception.BusinessRuleValidationException;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

public final class RulesChecker {

    private RulesChecker() {
    }

    public static void checkRule(BusinessRule rule) {
        if (rule.isBroken()) {
            throw new BusinessRuleValidationException(rule);
        }
    }
    
    public static void checkRule(BusinessRule rule, IBrokenRuleCallback callback) {
        if (rule.isBroken()) {
            callback.onFail();
            throw new BusinessRuleValidationException(rule);
        }
    }

    public interface IBrokenRuleCallback {
        public void onFail();
    }
}
