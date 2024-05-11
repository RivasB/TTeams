package cloud.tteams.identity.organization.infrastructure.service;

import java.util.List;

import cloud.tteams.identity.organization.domain.repository.IAgencyCommandRepository;
import cloud.tteams.identity.organization.domain.repository.IAgencyQueryRepository;
import cloud.tteams.identity.organization.domain.service.IAgencyService;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cloud.tteams.identity.organization.domain.Agency;
import cloud.tteams.identity.organization.domain.AgencyDescription;
import cloud.tteams.identity.organization.domain.AgencyId;
import cloud.tteams.identity.organization.domain.AgencyLatitude;
import cloud.tteams.identity.organization.domain.AgencyLongitude;
import cloud.tteams.identity.organization.domain.AgencyName;
import cloud.tteams.identity.organization.domain.AgencyRegion;
import cloud.tteams.identity.organization.domain.AgencyState;
import cloud.tteams.identity.organization.domain.rules.AgencyCantonRequiredRule;
import cloud.tteams.identity.organization.domain.rules.AgencyCountryRequiredRule;
import cloud.tteams.identity.organization.domain.rules.AgencyNameMustBeUniqueRule;
import cloud.tteams.identity.organization.domain.rules.AgencyNameRequiredRule;
import cloud.tteams.identity.organization.domain.rules.AgencyParishRequiredRule;
import cloud.tteams.identity.organization.domain.rules.AgencyProvinceRequiredRule;
import cloud.tteams.identity.organization.domain.rules.AgencyRegionMustBeRequiredRule;
import cloud.tteams.identity.organization.domain.rules.AgencyStateRequiredRule;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.RulesChecker;
import cloud.tteams.share.core.domain.service.IEventService;

@Service
public class DomainAgencyService implements IAgencyService {
    private final IAgencyCommandRepository commandRepository;
    private final IAgencyQueryRepository queryRepository;
    private final IEventService<Agency> eventService;

    @Value("${kafka.messenger.organization:false}")
    private boolean messengerIsActive;

    public DomainAgencyService(IAgencyCommandRepository commandRepository, IAgencyQueryRepository queryRepository,
            IEventService<Agency> eventService) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.eventService = eventService;
    }

    @Override
    public void createAgency(Agency agency) {
        RulesChecker.checkRule(new AgencyNameRequiredRule(agency.getName().value()));
        RulesChecker.checkRule(new AgencyNameMustBeUniqueRule(this, agency));
        RulesChecker.checkRule(new AgencyCountryRequiredRule(agency.getCountry().getName().getValue()));
        RulesChecker.checkRule(new AgencyProvinceRequiredRule(agency.getProvince().getName().getValue()));
        RulesChecker.checkRule(new AgencyCantonRequiredRule(agency.getCanton().getName().getValue()));
        RulesChecker.checkRule(new AgencyParishRequiredRule(agency.getParroquia().getName().getValue()));
        RulesChecker.checkRule(new AgencyStateRequiredRule(agency.getState()));
        RulesChecker.checkRule(new AgencyRegionMustBeRequiredRule(agency.getRegion().getValue()));

        commandRepository.create(agency);
        if (messengerIsActive) {
            eventService.create(agency);
        }
    }

    @Override
    public void delete(AgencyId id) {
        Agency agencyDelete = queryRepository.findById(id);

        if (agencyDelete.getState().equals(AgencyState.ACTIVE)) {
            AgencyId dId = agencyDelete.getId();
            AgencyDescription dDescription = agencyDelete.getDescription();
            AgencyName dName = agencyDelete.getName();
            AgencyState dState = AgencyState.INACTIVE;
            AgencyLatitude dLatitude = agencyDelete.getLatitute();
            AgencyLongitude dLongitude = agencyDelete.getLongitude();

            GeographicLocation dCountry = agencyDelete.getCountry();
            GeographicLocation dProvince = agencyDelete.getProvince();
            GeographicLocation dCanton = agencyDelete.getCanton();
            GeographicLocation dParroquia = agencyDelete.getParroquia();
            AgencyRegion dRegion = agencyDelete.getRegion();

            Agency dAgency = new Agency(dId, dName, dDescription, dCountry, dProvince, dCanton, dParroquia,
                    dRegion, dState, dLatitude, dLongitude);
            commandRepository.update(dAgency);
            if (messengerIsActive) {
                eventService.update(dAgency);
            }
        } else {
            commandRepository.delete(agencyDelete);
            if (messengerIsActive) {
                eventService.delete(agencyDelete);
            }
        }
    }

    @Override
    public void updateAgency(Agency agency) {

        Agency toUpdate = queryRepository.findById(agency.getId());

        AgencyName name = agency.getName() == null ? toUpdate.getName() : agency.getName();
        AgencyDescription description = agency.getDescription() == null ? toUpdate.getDescription()
                : agency.getDescription();

        GeographicLocation country = agency.getCountry() == null ? toUpdate.getCountry() : agency.getCountry();
        GeographicLocation province = agency.getProvince() == null ? toUpdate.getProvince() : agency.getProvince();
        GeographicLocation canton = agency.getCanton() == null ? toUpdate.getCanton() : agency.getCanton();
        GeographicLocation parroquia = agency.getParroquia() == null ? toUpdate.getParroquia() : agency.getParroquia();
        AgencyRegion region = agency.getRegion() == null ? toUpdate.getRegion() : agency.getRegion();

        AgencyLatitude latitude = agency.getLatitute() == null ? toUpdate.getLatitute() : agency.getLatitute();
        AgencyLongitude longitude = agency.getLongitude() == null ? toUpdate.getLongitude() : agency.getLongitude();

        AgencyState state = agency.getState();

        Agency agencyUpdate = new Agency(agency.getId(), name, description, country, province, canton, parroquia,
                region, state, latitude, longitude);

        RulesChecker.checkRule(new AgencyNameRequiredRule(agencyUpdate.getName().value()));
        RulesChecker.checkRule(new AgencyNameMustBeUniqueRule(this, agencyUpdate));
        RulesChecker.checkRule(new AgencyCountryRequiredRule(agencyUpdate.getCountry().getName().getValue()));
        RulesChecker.checkRule(new AgencyProvinceRequiredRule(agencyUpdate.getProvince().getName().getValue()));
        RulesChecker.checkRule(new AgencyCantonRequiredRule(agencyUpdate.getCanton().getName().getValue()));
        RulesChecker.checkRule(new AgencyParishRequiredRule(agencyUpdate.getParroquia().getName().getValue()));
        RulesChecker.checkRule(new AgencyStateRequiredRule(agencyUpdate.getState()));
        RulesChecker.checkRule(new AgencyRegionMustBeRequiredRule(agencyUpdate.getRegion().getValue()));

        commandRepository.update(agencyUpdate);
        if (messengerIsActive) {
            eventService.update(agencyUpdate);
        }
    }

    @Override
    public Agency findById(AgencyId id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse getPaginatedAgency(Pageable pageable, String name, String province, String canton, String description, String latitude, String longitude, AgencyState state, String filter) {
        return queryRepository.findAll(pageable, name, province, canton, description, latitude, longitude, state, filter);
    }

    @Override
    public Long countByName(AgencyName name) {
        return queryRepository.countByName(name.value());
    }

    @Override
    public Agency findByName(AgencyName name) {
        return queryRepository.findByName(name.value());
    }

//    @Override
//    public MessagePaginatedResponse getPaginatedAgency(Pageable pageable, String filter) {
//        if (!"".equals(filter)) {
//            return this.queryRepository.allAgencyWithFilter(pageable, filter);
//        }
//
//        return this.queryRepository.allAgencyWithOutFilter(pageable);
//    }

    @Override
    public Long countByIdIsNotAndName(AgencyId id, AgencyName name) {
        return queryRepository.countByIdIsNotAndName(id.value(), name.value());
    }

    @Override
    public List<Agency> findByProvince(GeographicLocationId geographicLocationId) {
        return queryRepository.findAgencyByProvince(geographicLocationId);
    }

    @Override
    public List<Agency> findByCanton(GeographicLocationId geographicLocationId) {
        return queryRepository.findAgencyByCanton(geographicLocationId);
    }

    @Override
    public void spreadAgencys() {
        List<Agency> allAgency = commandRepository.findAll();
        allAgency.stream().forEach(item -> {
            eventService.create(item);
        });
    }

}
