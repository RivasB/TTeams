package cloud.tteams.identity.aplication.infrastructure.adapter.command;

import cloud.tteams.identity.aplication.infrastructure.repository.hibernate.AplicationDto;
import cloud.tteams.identity.aplication.domain.Aplication;
import cloud.tteams.identity.aplication.domain.repository.IAplicationCommandRepository;
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
