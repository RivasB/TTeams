package ec.gob.registrocivil.identity.agency.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AgencyNameAlreadyExits extends RuntimeException {

    public AgencyNameAlreadyExits(String message) {
        super(message);
    }

}
