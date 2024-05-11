package cloud.tteams.identity.application.infrastructure.adapter.command;

import cloud.tteams.identity.application.infrastructure.repository.hibernate.AplicationDto;
import cloud.tteams.identity.application.domain.Aplication;
import cloud.tteams.identity.application.domain.repository.IAplicationCommandRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PostgresDBAplicationCommandRepository implements IAplicationCommandRepository {

    private final ISpringAplicationWriteDataJPARepository aplicationRepository;

    public PostgresDBAplicationCommandRepository(final ISpringAplicationWriteDataJPARepository aplicationRepository) {
        this.aplicationRepository = aplicationRepository;
    }

    @Override
    public void create(Aplication aplication) {
        aplicationRepository.save(new AplicationDto(aplication));
    }

    @Override
    public void update(Aplication aplication) {
        aplicationRepository.save(new AplicationDto(aplication));
    }

    @Override
    public void delete(Aplication aplication) {
        aplicationRepository.delete(new AplicationDto(aplication));
    }

}
