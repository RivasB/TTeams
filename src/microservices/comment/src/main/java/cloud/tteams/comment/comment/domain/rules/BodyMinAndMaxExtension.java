package cloud.tteams.comment.comment.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;

public class BodyMinAndMaxExtension extends BusinessRule {

    private final String body;

    public BodyMinAndMaxExtension(String body) {
        super("Body must be greater than 10 characters and lesser than 2000 characters");
        this.body = body;
    }

    @Override
    public boolean isBroken() {
        int longitud = this.body.length();
        return longitud < 10 || longitud > 4000;
    }

}
