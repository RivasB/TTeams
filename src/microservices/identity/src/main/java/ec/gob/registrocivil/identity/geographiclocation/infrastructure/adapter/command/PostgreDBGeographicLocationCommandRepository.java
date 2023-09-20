package ec.gob.registrocivil.identity.geographiclocation.infrastructure.adapter.command;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.identity.geographiclocation.domain.repository.IGeographicLocationCommandRepository;
import ec.gob.registrocivil.identity.geographiclocation.infrastructure.repository.hibernate.GeographicLocationDto;

@Component
@Primary
public class PostgreDBGeographicLocationCommandRepository implements IGeographicLocationCommandRepository {

    private final IGeographicLocationCommandJPARepository commandJPARepository;

    public PostgreDBGeographicLocationCommandRepository(IGeographicLocationCommandJPARepository commandJPARepository) {
        this.commandJPARepository = commandJPARepository;
    }

    @Override
    public void create(GeographicLocation geographiclocation) {
        commandJPARepository.save(new GeographicLocationDto(geographiclocation));
    }

    @Override
    public void update(GeographicLocation geographiclocation) {
        commandJPARepository.save(new GeographicLocationDto(geographiclocation));
    }

    @Override
    public void delete(GeographicLocation geographiclocation) {
        commandJPARepository.delete(new GeographicLocationDto(geographiclocation));
    }

    @Override
    public List<GeographicLocation> findAll() {
        return commandJPARepository.findAll().stream().map(item -> {
            return item.toAggregate();
        }).toList();
    }

}
