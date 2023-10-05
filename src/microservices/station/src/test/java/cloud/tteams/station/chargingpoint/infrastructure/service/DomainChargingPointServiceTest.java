package cloud.tteams.station.chargingpoint.infrastructure.service;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.chargingpoint.domain.ChargingPoint;
import cloud.tteams.station.chargingpoint.domain.ChargingPointId;
import cloud.tteams.station.chargingpoint.domain.ChargingPointPowerLevel;
import cloud.tteams.station.chargingpoint.domain.repository.IChargingPointCommandRepository;
import cloud.tteams.station.chargingpoint.domain.repository.IChargingPointQueryRepository;
import cloud.tteams.station.chargingpoint.infrastructure.exception.ChargingPointNotFound;
import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DomainChargingPointServiceTest {

    private IChargingPointQueryRepository queryRepository;

    private IChargingPointCommandRepository commandRepository;

    private DomainChargingPointService domainChargingPointService;

    private ChargingPoint existingChargingPoint;

    @Before
    public void setup(){
        queryRepository = mock(IChargingPointQueryRepository.class);
        commandRepository = mock(IChargingPointCommandRepository.class);
        Log logger = mock(Log.class);
        domainChargingPointService = new DomainChargingPointService(commandRepository,queryRepository,logger);
        existingChargingPoint = new ChargingPoint(new ChargingPointId(UUID.randomUUID()),
                new ChargingPointPowerLevel(100),null);
        commandRepository.create(existingChargingPoint);
    }

    @Test
    public void testCreate_shouldCallCommandRepositoryCreate() {
        domainChargingPointService.create(existingChargingPoint);
        verify(commandRepository, times(2)).create(existingChargingPoint);
    }

    @Test
    public void testUpdate_WithDifferentValues_ShouldUpdate() {
        // Arrange
        ChargingPointId chargingPointId = existingChargingPoint.getId();
        ChargingPoint updatedChargingPoint = new ChargingPoint(chargingPointId, new ChargingPointPowerLevel(0),null);
        when(queryRepository.findById(chargingPointId)).thenReturn(existingChargingPoint);
        assertEquals(existingChargingPoint.getId(), updatedChargingPoint.getId());
        domainChargingPointService.update(updatedChargingPoint);
        verify(commandRepository, times(1)).update(existingChargingPoint);
        assertEquals(existingChargingPoint.toString(), updatedChargingPoint.toString());
    }

    @Test()
    public void delete_shouldCallCommandRepositoryDelete() {
        when(domainChargingPointService.findById(existingChargingPoint.getId())).thenReturn(existingChargingPoint);
        domainChargingPointService.delete(existingChargingPoint.getId());
        verify(commandRepository, times(1)).delete(existingChargingPoint);
    }

    @Test
    public void testFindByIdWithValidId() {
        ChargingPointId validId = existingChargingPoint.getId();
        when(queryRepository.findById(validId)).thenReturn(existingChargingPoint);
        ChargingPoint foundChargingPoint = queryRepository.findById(validId);
        assertNotNull(foundChargingPoint);
        assertEquals(validId, foundChargingPoint.getId());
    }

    @Test
    public void testFindByIdWithInvalidId() {
        ChargingPointId invalidId = new ChargingPointId(UUID.randomUUID());
        when(queryRepository.findById(invalidId)).thenThrow(ChargingPointNotFound.class);
        assertThrows(ChargingPointNotFound.class, () -> queryRepository.findById(invalidId));
    }

    @Test
    public void testFindAllWithValidPageable() {
        Pageable pageable = Pageable.ofSize(20).withPage(0);
        Page<ChargingPoint> expectedPage = new PageImpl<>(List.of(existingChargingPoint));
        MessagePaginatedResponse expectedResponse =
                new MessagePaginatedResponse(List.of(existingChargingPoint), expectedPage);
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
