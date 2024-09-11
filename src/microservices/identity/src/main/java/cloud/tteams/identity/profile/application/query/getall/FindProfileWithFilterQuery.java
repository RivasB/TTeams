package cloud.tteams.identity.profile.application.query.getall;

import cloud.tteams.share.core.domain.State;
import org.springframework.data.domain.Pageable;

import cloud.tteams.share.core.domain.bus.query.IQuery;

import java.util.UUID;

public record FindProfileWithFilterQuery(Pageable pageable, String filter, String name, String description, State state,
                                         UUID organization) implements IQuery {

}
