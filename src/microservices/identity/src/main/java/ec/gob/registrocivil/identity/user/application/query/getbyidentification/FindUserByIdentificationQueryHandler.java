package ec.gob.registrocivil.identity.user.application.query.getbyidentification;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;
import ec.gob.registrocivil.identity.user.domain.User;
import ec.gob.registrocivil.identity.user.domain.UserIdentification;
import ec.gob.registrocivil.identity.user.domain.service.IUserService;

@Component
public class FindUserByIdentificationQueryHandler
        implements IQueryHandler<FindUserByIdentificationQuery, FindUserByIdentificationResponse> {

    private final IUserService userService;

    public FindUserByIdentificationQueryHandler(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public FindUserByIdentificationResponse handle(FindUserByIdentificationQuery query) {

        UserIdentification identification = new UserIdentification(query.getIdentification());
        User user = userService.findByIdentification(identification);

        return new FindUserByIdentificationResponse(user);
    }

}
