package cloud.tteams.identity.organization.application.command.create;

import cloud.tteams.identity.organization.domain.service.IAgencyService;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationId;
import cloud.tteams.identity.geographiclocation.domain.service.IGeographicLocationService;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.organization.domain.Agency;
import cloud.tteams.identity.organization.domain.AgencyDescription;
import cloud.tteams.identity.organization.domain.AgencyId;
import cloud.tteams.identity.organization.domain.AgencyLatitude;
import cloud.tteams.identity.organization.domain.AgencyLongitude;
import cloud.tteams.identity.organization.domain.AgencyName;
import cloud.tteams.identity.organization.domain.AgencyRegion;
import cloud.tteams.identity.organization.domain.AgencyState;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;

@Component
public class CreateAgencyCommandHandler implements ICommandHandler<CreateAgencyCommand> {

    private final IAgencyService agencyService;
    private final IGeographicLocationService locationService;

    public CreateAgencyCommandHandler(IAgencyService agencyService, IGeographicLocationService locationService) {
        this.agencyService = agencyService;
        this.locationService = locationService;
    }

    @Override
    public void handle(CreateAgencyCommand command) {
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

        AgencyState state = AgencyState.ACTIVE;

        Agency agency = new Agency(id, name, description, country, province, canton, parroquia, region, state, latitude,
                longitude);

        agencyService.createAgency(agency);
    }
}
