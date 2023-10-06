package cloud.tteams.station.station.infrastructure.service;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.station.domain.*;
import cloud.tteams.station.station.domain.repository.IStationCommandRepository;
import cloud.tteams.station.station.domain.repository.IStationQueryRepository;
import cloud.tteams.station.station.infrastructure.exception.StationNotFoundException;
import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DomainStationServiceTest {
    private IStationQueryRepository queryRepository;
    private IStationCommandRepository commandRepository;
    private DomainStationService domainStationService;
    private Station existingStation;

    @Before
    public void setup() {
        queryRepository = mock(IStationQueryRepository.class);
        commandRepository = mock(IStationCommandRepository.class);
        StationEventService eventPublisher = mock(StationEventService.class);
        domainStationService = new DomainStationService(commandRepository, queryRepository, eventPublisher);
        existingStation = new Station(new StationId(UUID.randomUUID()), null, StationChargerType.AC,
                new StationChargingPoints(new ArrayList<>()), StationStatus.IN_USE);
        commandRepository.create(existingStation);
    }

    @Test
    public void testCreate_shouldCallCommandRepositoryCreate() {
        domainStationService.create(existingStation);
        verify(commandRepository, times(2)).create(existingStation);
    }

    @Test
    public void testUpdate_WithDifferentValues_ShouldUpdate() {
        // Arrange
        StationId stationId = existingStation.getId();
        Station updatedStation = new Station(stationId, null, StationChargerType.DC_FAST,
                new StationChargingPoints(new ArrayList<>()), StationStatus.AVAILABLE);
        when(queryRepository.findById(stationId)).thenReturn(existingStation);
        assertEquals(existingStation.getId(), updatedStation.getId());
        domainStationService.update(updatedStation);
        verify(commandRepository, times(1)).update(existingStation);
        assertEquals(existingStation.toString(), updatedStation.toString());
    }

    @Test
    public void delete_shouldCallCommandRepositoryDelete() {
        when(domainStationService.findById(existingStation.getId())).thenReturn(existingStation);
        domainStationService.delete(existingStation.getId());
        verify(commandRepository, times(1)).delete(existingStation);
    }

    @Test
    public void testFindByIdWithValidId() {
        StationId validId = existingStation.getId();
        when(queryRepository.findById(validId)).thenReturn(existingStation);
        Station foundStation = queryRepository.findById(validId);
        assertNotNull(foundStation);
        assertEquals(validId, foundStation.getId());
    }

    @Test
    public void testFindByIdWithInvalidId() {
        StationId invalidId = new StationId(UUID.randomUUID());
        when(queryRepository.findById(invalidId)).thenThrow(StationNotFoundException.class);
        assertThrows(StationNotFoundException.class, () -> queryRepository.findById(invalidId));
    }

    @Test
    public void testFindAllWithValidPageable() {
        Pageable pageable = Pageable.ofSize(20).withPage(0);
        Page<Station> expectedPage = new PageImpl<>(List.of(existingStation));
        MessagePaginatedResponse expectedResponse =
                new MessagePaginatedResponse(List.of(existingStation), expectedPage);
        when(queryRepository.findAll(pageable)).thenReturn(expectedResponse);
        MessagePaginatedResponse actualResponse = queryRepository.findAll(pageable);
        assertEquals(expectedResponse.getData(), actualResponse.getData());
    }

    @Test
    public void testFindAllWithInvalidPageable() {
        Pageable invalidPageable = Pageable.ofSize(1).withPage(1);
        when(queryRepository.findAll(invalidPageable)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> queryRepository.findAll(invalidPageable));
    }


}
