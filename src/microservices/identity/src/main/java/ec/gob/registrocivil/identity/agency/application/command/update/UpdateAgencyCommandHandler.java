package ec.gob.registrocivil.identity.agency.application.command.update;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.agency.domain.Agency;
import ec.gob.registrocivil.identity.agency.domain.AgencyDescription;
import ec.gob.registrocivil.identity.agency.domain.AgencyId;
import ec.gob.registrocivil.identity.agency.domain.AgencyLatitude;
import ec.gob.registrocivil.identity.agency.domain.AgencyLongitude;
import ec.gob.registrocivil.identity.agency.domain.AgencyName;
import ec.gob.registrocivil.identity.agency.domain.AgencyRegion;
import ec.gob.registrocivil.identity.agency.domain.AgencyState;
import ec.gob.registrocivil.identity.agency.domain.service.IAgencyService;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationId;
import ec.gob.registrocivil.identity.geographiclocation.domain.service.IGeographicLocationService;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandHandler;

@Component
public class UpdateAgencyCommandHandler implements ICommandHandler<UpdateAgencyCommand> {

    private final IAgencyService agencyService;
    private final IGeographicLocationService locationService;

    public UpdateAgencyCommandHandler(IAgencyService agencyService, IGeographicLocationService locationService) {
        this.agencyService = agencyService;
        this.locationService = locationService;
    }

    @Override
    public void handle(UpdateAgencyCommand command) {
        AgencyId id = new AgencyId(command.getId());
        AgencyName name = new AgencyName(command.getName());
        AgencyDescription description = new AgencyDescription(command.getDescription());

        GeographicLocation country = locationService.findById(new GeographicLocationId(command.getCountry()));
        GeographicLocation province = locationService.findById(new GeographicLocationId(command.getProvince()));
        GeographicLocation canton = locationService.findById(new GeographicLocationId(command.getCanton()));
        GeographicLocation parroquia = locationService.findById(new GeographicLocationId(command.getParroquia()));
        AgencyRegion region = new AgencyRegion(command.getRegion());

        AgencyLatitude latitude = new AgencyLatitude(command.getLatitude());
        AgencyLongitude longitude = new AgencyLongitude(command.getLongitude());

        AgencyState state = command.getState();

        Agency agency = new Agency(id, name, description, country, province, canton, parroquia, region, state, latitude,
                longitude);

        agencyService.updateAgency(agency);
    }
}
