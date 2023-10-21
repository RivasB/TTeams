package cloud.tteams.share.user.infrastructure.service;

import cloud.tteams.share.user.domain.*;
import cloud.tteams.share.user.domain.repository.IUserCommandRepository;
import cloud.tteams.share.user.domain.repository.IUserQueryRepository;
import cloud.tteams.share.user.domain.service.IUserService;
import cloud.tteams.share.user.infrastructure.exceptions.UserNuiNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class DomainUserService implements IUserService {
    private final IUserCommandRepository commandRepository;
    private final IUserQueryRepository queryRepository;
    private final Log logger = LogFactory.getLog(this.getClass());

    public DomainUserService(IUserCommandRepository commandRepository, IUserQueryRepository queryRepository) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
    }

    @Override
    public void createUser(User user) {
        this.commandRepository.create(user);
    }

    @Override
    public User findById(UserId id) {
        return queryRepository.findById(id);
    }

    @Override
    public void delete(UserId id) {
        User user = this.queryRepository.findById(id);
        this.commandRepository.delete(user);
    }

    @Override
    public void updateUser(User user) {
        User toUpdate = this.queryRepository.findById(user.getId());
        Field[] fields = user.getClass().getDeclaredFields();
        try  {
            for (Field attrib : fields) {
                attrib.setAccessible(true);
                Object valueStation = attrib.get(user);
                Object valueToUpdateStation = attrib.get(toUpdate);
                if (valueStation != null && !valueStation.equals(valueToUpdateStation)
                        && attrib.getType().isAssignableFrom(valueStation.getClass())) {
                    attrib.set(toUpdate, valueStation);
                }
            }
        } catch (IllegalAccessException e){
            logger.error(e.getMessage());
        }
        commandRepository.update(toUpdate);
    }

    @Override
    public User findByIdentification(UserIdentification userIdentification) {
        return queryRepository.findByIdentification(userIdentification.getValue())
                .orElseThrow(UserNuiNotFoundException::new);
    }

    @Override
    public boolean existsById(UserId id) {
        return queryRepository.existsById(id);
    }
}
