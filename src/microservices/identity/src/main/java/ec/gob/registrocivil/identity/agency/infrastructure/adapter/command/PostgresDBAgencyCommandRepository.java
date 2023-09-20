package ec.gob.registrocivil.identity.agency.infrastructure.adapter.command;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.agency.domain.Agency;
import ec.gob.registrocivil.identity.agency.domain.repository.IAgencyCommandRepository;
import ec.gob.registrocivil.identity.agency.infrastructure.repository.hibernate.AgencyDto;

@Component
@Primary
public class PostgresDBAgencyCommandRepository implements IAgencyCommandRepository {

    private final ISpringAgencyWriteDataJPARepository agencyRepository;

    public PostgresDBAgencyCommandRepository(final ISpringAgencyWriteDataJPARepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public void create(Agency agency) {

        agencyRepository.save(new AgencyDto(agency));
    }

    @Override
    public void update(Agency agency) {
        agencyRepository.save(new AgencyDto(agency));
    }

    @Override
    public void delete(Agency agency) {
        agencyRepository.delete(new AgencyDto(agency));
    }

    @Override
    public List<Agency> findAll() {
        return agencyRepository.findAll().stream().map(item -> {
            return item.toAggregate();
        }).toList();
    }
}
