package cloud.tteams.identity.user.application.query.getbyid;

import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.identity.user.domain.User;
import cloud.tteams.identity.user.domain.UserId;
import cloud.tteams.identity.user.domain.service.IUserService;

@Component
public class FindUserByIdQueryHandler implements IQueryHandler<FindUserByIdQuery, FindUserByIdResponse> {

    private final IUserService userService;

    public FindUserByIdQueryHandler(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public FindUserByIdResponse handle(FindUserByIdQuery query) {

        UserId id = new UserId(query.getId());
        User user = userService.findById(id);

        return new FindUserByIdResponse(user);
    }

}
