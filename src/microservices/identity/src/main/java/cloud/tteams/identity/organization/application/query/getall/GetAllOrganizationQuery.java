package cloud.tteams.identity.organization.application.query.getall;

import cloud.tteams.share.core.domain.State;
import org.springframework.data.domain.Pageable;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public record GetAllOrganizationQuery(Pageable pageable, String name, String description, String contact,
                                      State state) implements IQuery {

}
