package cloud.tteams.identity.user.application.query.getbyid;

import cloud.tteams.identity.user.application.UserResponse;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.identity.user.domain.service.IUserService;

@Component
public class FindUserByIdQueryHandler implements IQueryHandler<FindUserByIdQuery, UserResponse> {

    private final IUserService userService;

    public FindUserByIdQueryHandler(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserResponse handle(FindUserByIdQuery query) {
        return new UserResponse(userService.findById(query.id()));
    }

}
