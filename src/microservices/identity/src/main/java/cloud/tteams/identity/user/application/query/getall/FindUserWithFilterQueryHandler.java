package cloud.tteams.identity.user.application.query.getall;

import org.springframework.stereotype.Component;

import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.identity.user.domain.service.IUserService;

@Component
public class FindUserWithFilterQueryHandler implements IQueryHandler<FindUserWithFilterQuery, MessagePaginatedResponse> {

    private final IUserService userService;

    public FindUserWithFilterQueryHandler(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public MessagePaginatedResponse handle(FindUserWithFilterQuery query) {
        return userService.getPaginatedUsers(query.pageable(), query.firstName(), query.lastName(), query.identification(), query.email(), query.type(), query.state(), query.filter());
    }
}
