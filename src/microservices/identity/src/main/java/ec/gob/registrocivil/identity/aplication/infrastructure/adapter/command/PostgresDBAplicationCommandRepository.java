package ec.gob.registrocivil.identity.aplication.infrastructure.adapter.command;

import ec.gob.registrocivil.identity.aplication.domain.Aplication;
import ec.gob.registrocivil.identity.aplication.domain.repository.IAplicationCommandRepository;
import ec.gob.registrocivil.identity.aplication.infrastructure.repository.hibernate.AplicationDto;
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
