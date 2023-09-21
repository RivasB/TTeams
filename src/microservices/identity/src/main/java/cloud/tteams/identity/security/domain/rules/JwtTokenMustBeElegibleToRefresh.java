package cloud.tteams.identity.security.domain.rules;

import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import cloud.tteams.share.core.domain.rules.BusinessRule;

public class JwtTokenMustBeElegibleToRefresh extends BusinessRule {

    Date now;

    Date expiration;

    public JwtTokenMustBeElegibleToRefresh(Date now, Date expiration) {
        super(DomainErrorMessage.JWT_TOKEN_MUST_BE_ELEGIBLE_TO_REFRESH, "Token can not be refreshed");
        this.now = now;
        this.expiration = expiration;
    }

    @Override
    public boolean isBroken() {
        long diffInMillis = Math.abs(now.getTime() - expiration.getTime());
        long twoHoursInMillis = TimeUnit.HOURS.toMillis(2);
        return (now.after(expiration)) ? diffInMillis > twoHoursInMillis : diffInMillis > twoHoursInMillis;
    }

}
