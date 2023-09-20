package ec.gob.registrocivil.identity.agency.domain.service;

import java.util.List;

import ec.gob.registrocivil.identity.agency.domain.AgencyState;
import org.springframework.data.domain.Pageable;

import ec.gob.registrocivil.identity.agency.domain.Agency;
import ec.gob.registrocivil.identity.agency.domain.AgencyId;
import ec.gob.registrocivil.identity.agency.domain.AgencyName;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationId;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;

public interface IAgencyService {
    public void createAgency(Agency agency);

    public void delete(AgencyId id);

    public void updateAgency(Agency agency);

    public Agency findById(AgencyId id);

    public MessagePaginatedResponse getPaginatedAgency(Pageable pageable, String name, String province, String canton, String description, String latitude, String longitude, AgencyState state, String filter);

    public Long countByName(AgencyName name);

    public Agency findByName(AgencyName name);

    public Long countByIdIsNotAndName(AgencyId id, AgencyName name);

    public List<Agency> findByProvince(GeographicLocationId geographicLocationId);
    
    public List<Agency> findByCanton(GeographicLocationId geographicLocationId);

    public void spreadAgencys();
}
