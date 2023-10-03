package cloud.tteams.station.station;

import cloud.tteams.station.chargingpoint.domain.ChargingPoint;
import cloud.tteams.station.location.domain.*;
import cloud.tteams.station.station.domain.*;
import cloud.tteams.station.station.domain.repository.IStationCommandRepository;
import cloud.tteams.station.station.domain.repository.IStationQueryRepository;
import cloud.tteams.station.station.infrastructure.service.DomainStationService;
import cloud.tteams.station.station.infrastructure.service.StationEventService;
import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class StationServiceTest {
    private IStationQueryRepository stationRepository;
    private IStationCommandRepository commandRepository;
    private StationEventService eventPublisher;
    private DomainStationService stationService;

    @Before
    public void setup() {
        stationRepository = mock(IStationQueryRepository.class);
        commandRepository = mock(IStationCommandRepository.class);
        eventPublisher = mock(StationEventService.class);
        Log logger = mock(Log.class);
        stationService = new DomainStationService(commandRepository, stationRepository, eventPublisher, logger);
    }

    @Test
    public void testUpdate_WithMatchingValues_ShouldNotUpdate() {
        // Arrange
        UUID id = UUID.randomUUID();
        StationId sId = new StationId(id);
        StationId sId1 = new StationId(id);
        Location location = new Location(new LocationId(id),
                new LocationAddress("Location A"),
                new LocationLatitude("00.00"),
                new LocationLongitude("00.00"));
        Location location1 = new Location(new LocationId(id),
                new LocationAddress("Location A"),
                new LocationLatitude("00.00"),
                new LocationLongitude("00.00"));
        List<ChargingPoint> list = new ArrayList<>();
        StationChargingPoints chargingPoints = new StationChargingPoints(list);
        StationChargingPoints chargingPoints1 = new StationChargingPoints(list);
        Station existingStation = new Station(sId, location, StationChargerType.AC, chargingPoints,
                StationStatus.IN_USE);
        Station updatedStation = new Station(sId1, location1, StationChargerType.AC, chargingPoints1,
                StationStatus.IN_USE);
        when(stationRepository.findById(sId)).thenReturn(existingStation);
        // Act
        stationService.update(updatedStation);
        // Assert
        verify(commandRepository, never()).update(any(Station.class));
        verify(eventPublisher, never()).update(any(Station.class));
    }

    @Test
    public void testUpdate_WithDifferentValues_ShouldUpdate() {
        /** Arrange
        Station existingStation = new Station(1, "Station A", "Location A");
        Station updatedStation = new Station(1, "Station B", "Location B");

        when(stationRepository.findById(1)).thenReturn(existingStation);

        // Act
        stationService.update(updatedStation);

        // Assert
        verify(commandRepository).update(existingStation);
        verify(eventPublisher).publishEvent(existingStation, EventType.UPDATED);
        assertEquals("Station B", existingStation.getName());
        assertEquals("Location B", existingStation.getLocation()); **/
    }

    @Test
    public void testUpdate_WithInvalidStationId_ShouldThrowException() {
        /** Arrange
        Station updatedStation = new Station(1, "Station A", "Location A");

        when(stationRepository.findById(1)).thenReturn(null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            stationService.update(updatedStation);
        });**/
    }
}
