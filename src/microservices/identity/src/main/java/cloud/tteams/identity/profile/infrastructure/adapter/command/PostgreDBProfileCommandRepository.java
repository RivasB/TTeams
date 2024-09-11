package cloud.tteams.identity.profile.infrastructure.adapter.command;

import cloud.tteams.identity.profile.infrastructure.repository.hibernate.ProfileEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.repository.IProfileCommandRepository;

@Component
@Primary
public class PostgreDBProfileCommandRepository implements IProfileCommandRepository {

    private final IProfileCommandJPARepository commandJPARepository;

    public PostgreDBProfileCommandRepository(IProfileCommandJPARepository commandJPARepository) {
        this.commandJPARepository = commandJPARepository;
    }

    @Override
    public void create(Profile profile) {
        commandJPARepository.save(new ProfileEntity(profile));
    }

    @Override
    public void update(Profile profile) {
        commandJPARepository.save(new ProfileEntity(profile));

    }

    @Override
    public void delete(Profile profile) {
        commandJPARepository.deleteById(profile.getId());
    }

}
