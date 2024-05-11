package cloud.tteams.identity.security.domain.rules;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import cloud.tteams.share.core.domain.rules.BusinessRule;

public class TokenRefreshEligibility extends BusinessRule {

    Date now;

    Date expiration;

    public TokenRefreshEligibility(Date now, Date expiration) {
        super("Token can not be refreshed");
        this.now = now;
        this.expiration = expiration;
    }

    @Override
    public boolean isBroken() {
        long diffInMillis = Math.abs(now.getTime() - expiration.getTime());
        long twoHoursInMillis = TimeUnit.HOURS.toMillis(2);
        return diffInMillis > twoHoursInMillis;
    }

}
