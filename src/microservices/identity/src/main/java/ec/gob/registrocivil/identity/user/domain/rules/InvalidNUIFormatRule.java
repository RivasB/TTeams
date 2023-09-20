package ec.gob.registrocivil.identity.user.domain.rules;

import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

public class InvalidNUIFormatRule extends BusinessRule {

    private String nui;

    public InvalidNUIFormatRule(String nui) {
        super(DomainErrorMessage.USER_NUI_FORMAT_INVALID, "Invalid NUI format!");
        this.nui = nui;
    }

    @Override
    public boolean isBroken() {

        if (null == nui)
            return false;

        // NUI must be a 10 digits length
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(nui);

        return !matcher.matches();
    }
}
