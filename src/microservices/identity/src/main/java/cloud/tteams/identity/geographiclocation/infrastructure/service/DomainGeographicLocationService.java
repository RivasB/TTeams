package cloud.tteams.identity.geographiclocation.infrastructure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationId;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationName;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationType;
import cloud.tteams.identity.geographiclocation.domain.repository.IGeographicLocationCommandRepository;
import cloud.tteams.identity.geographiclocation.domain.repository.IGeographicLocationQueryRepository;
import cloud.tteams.identity.geographiclocation.domain.rules.GeographicLocationNameRequiredRule;
import cloud.tteams.identity.geographiclocation.domain.rules.GeographicLocationTopologicalDependencyRule;
import cloud.tteams.identity.geographiclocation.domain.rules.GeographicLocationTypeRequiredRule;
import cloud.tteams.identity.geographiclocation.domain.service.IGeographicLocationService;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.RulesChecker;
import cloud.tteams.share.core.domain.service.IEventService;

@Service
public class DomainGeographicLocationService implements IGeographicLocationService {

    private final IGeographicLocationCommandRepository commandRepository;
    private final IGeographicLocationQueryRepository queryRepository;
    private final IEventService<GeographicLocation> eventService;

    @Value("${kafka.messenger.location:false}")
    private boolean messengerIsActive;

    public DomainGeographicLocationService(IGeographicLocationCommandRepository commandRepository,
            IGeographicLocationQueryRepository queryRepository, IEventService<GeographicLocation> eventService) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.eventService = eventService;
    }

    @Override
    public void create(GeographicLocation geographiclocation) {

        GeographicLocationId id = geographiclocation.getId();
        GeographicLocationName name = geographiclocation.getName();
        GeographicLocationType type = geographiclocation.getType();

        GeographicLocation parent = null;
        if (geographiclocation.getParent() != null) {
            parent = queryRepository.findById(geographiclocation.getParent().getId());
        }

        GeographicLocation toCreate = new GeographicLocation(id, name, type, parent);

        RulesChecker.checkRule(new GeographicLocationNameRequiredRule(toCreate));
        RulesChecker.checkRule(new GeographicLocationTypeRequiredRule(toCreate));
        RulesChecker.checkRule(new GeographicLocationTopologicalDependencyRule(toCreate));

        commandRepository.create(toCreate);
        if (messengerIsActive) {
            eventService.create(toCreate);
        }
    }

    @Override
    public void update(GeographicLocation geographiclocation) {

        GeographicLocationId id = geographiclocation.getId();
        GeographicLocationName name = geographiclocation.getName();
        GeographicLocationType type = geographiclocation.getType();

        GeographicLocation parent = null;
        if (geographiclocation.getParent() != null) {
            parent = queryRepository.findById(geographiclocation.getParent().getId());
        }

        GeographicLocation toUpdate = new GeographicLocation(id, name, type, parent);

        RulesChecker.checkRule(new GeographicLocationNameRequiredRule(toUpdate));
        RulesChecker.checkRule(new GeographicLocationTypeRequiredRule(toUpdate));
        RulesChecker.checkRule(new GeographicLocationTopologicalDependencyRule(toUpdate));

        commandRepository.update(toUpdate);
        if (messengerIsActive) {
            eventService.update(toUpdate);
        }
    }

    @Override
    public void delete(GeographicLocation geographiclocation) {
        commandRepository.delete(geographiclocation);
        if (messengerIsActive) {
            eventService.delete(geographiclocation);
        }
    }

    @Override
    public GeographicLocation findById(GeographicLocationId geographicLocationId) {
        return queryRepository.findById(geographicLocationId);
    }

    @Override
    public MessagePaginatedResponse getPaginatedGeographicLocation(Pageable pageable, String filter) {
        if (!"".equals(filter)) {
            return this.queryRepository.allGeographicLocationWithFilter(pageable, filter);
        }
        return this.queryRepository.allGeographicLocationWithOutFilter(pageable);
    }

    @Override
    public MessagePaginatedResponse getPaginatedByType(Pageable pageable, String filter, GeographicLocationType type) {
        if (!"".equals(filter)) {
            return this.queryRepository.allLocationsWithFilter(pageable, filter, type);
        }
        return this.queryRepository.allLocationsWithOutFilter(pageable, type);
    }

    @Override
    public MessagePaginatedResponse findByParent(Pageable pageable, GeographicLocationId parent) {
        return this.queryRepository.findByParent(pageable, parent);
    }

    @Override
    public void SpreadLocations() {
        List<GeographicLocation> allLocations = commandRepository.findAll();
        allLocations.stream().forEach(item -> {
            eventService.create(item);
        });
    }

}
