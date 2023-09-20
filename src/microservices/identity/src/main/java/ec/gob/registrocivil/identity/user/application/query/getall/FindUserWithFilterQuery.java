package ec.gob.registrocivil.identity.user.application.query.getall;

import ec.gob.registrocivil.identity.user.domain.UserState;
import ec.gob.registrocivil.identity.user.domain.UserType;
import org.springframework.data.domain.Pageable;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;

public class FindUserWithFilterQuery implements IQuery {

    private Pageable pageable;

    private String firstName;
    private String lastName;
    private String identification;
    private String email;
    private UserType type;
    private UserState state;

    private String filter;

    public FindUserWithFilterQuery(Pageable pageable, String firstName, String lastName, String identification, String email, UserType type, UserState state, String filter) {
        this.pageable = pageable;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.type = type;
        this.state = state;
        this.filter = filter;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdentification() {
        return identification;
    }

    public String getEmail() {
        return email;
    }

    public UserType getType() {
        return type;
    }

    public UserState getState() {
        return state;
    }

    public String getFilter() {
        return filter;
    }
}
