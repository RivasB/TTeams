package cloud.tteams.identity.user.application.query.getall;

import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;
import org.springframework.data.domain.Pageable;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public record FindUserWithFilterQuery(Pageable pageable, String firstName, String lastName, String identification,
                                      String email, UserType type, UserState state, String filter) implements IQuery {

}
