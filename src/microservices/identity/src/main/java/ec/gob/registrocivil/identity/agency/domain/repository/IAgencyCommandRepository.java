package ec.gob.registrocivil.identity.agency.domain.repository;

import java.util.List;

import ec.gob.registrocivil.identity.agency.domain.Agency;

public interface IAgencyCommandRepository {
    public void create(Agency agency);

    public void update(Agency agency);

    public void delete(Agency agency);

    public List<Agency> findAll();

}
