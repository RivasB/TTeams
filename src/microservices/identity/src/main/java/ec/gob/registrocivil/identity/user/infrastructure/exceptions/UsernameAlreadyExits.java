package ec.gob.registrocivil.identity.user.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsernameAlreadyExits extends RuntimeException {

    public UsernameAlreadyExits(String message) {
        super(message);
    }
}
