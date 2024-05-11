package cloud.tteams.identity.organization.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AgencyNotFoundException extends RuntimeException {

    public AgencyNotFoundException(String message) {
        super(message);
    }

}
