package cloud.tteams.identity.user.application.query.getbyemail;

import cloud.tteams.identity.security.domain.service.utility.IJavaWebTokenService;
import cloud.tteams.identity.user.application.UserResponse;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.identity.user.domain.User;
import cloud.tteams.identity.user.domain.service.IUserService;

@Component
public class FindUserByEmailQueryHandler
        implements IQueryHandler<FindUserByEmailQuery, UserResponse> {

    private final IUserService userService;

    private final IJavaWebTokenService jwTokenManager;

    public FindUserByEmailQueryHandler(IUserService userService, IJavaWebTokenService jwTokenManager) {
        this.userService = userService;
        this.jwTokenManager = jwTokenManager;
    }

    @Override
    public UserResponse handle(FindUserByEmailQuery query) {
        String email = jwTokenManager.getEmail(query.getEmail());
        User user = userService.findByEmail(email);
        return new UserResponse(user);
    }

}
