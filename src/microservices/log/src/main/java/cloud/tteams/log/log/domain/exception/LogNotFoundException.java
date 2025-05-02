package cloud.tteams.log.log.domain.exception;

import cloud.tteams.share.core.domain.exception.DomainException;

public class LogNotFoundException extends DomainException {
    public LogNotFoundException() {
        super("Log not found");
    }
}
