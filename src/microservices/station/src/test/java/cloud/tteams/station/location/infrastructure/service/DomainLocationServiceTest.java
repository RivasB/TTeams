package cloud.tteams.station.location.infrastructure.service;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.location.domain.*;
import cloud.tteams.station.location.domain.repository.ILocationCommandRepository;
import cloud.tteams.station.location.domain.repository.ILocationQueryRepository;
import cloud.tteams.station.location.infrastructure.exception.LocationNotFoundException;
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

public class DomainLocationServiceTest {

    private ILocationQueryRepository queryRepository;

    private ILocationCommandRepository commandRepository;

    private DomainLocationService domainLocationService;

    private Location existingLocation;

    @Before
    public void setup(){
        queryRepository = mock(ILocationQueryRepository.class);
        commandRepository = mock(ILocationCommandRepository.class);
        Log logger = mock(Log.class);
        domainLocationService = new DomainLocationService(commandRepository, queryRepository, logger);
        existingLocation = new Location(new LocationId(UUID.randomUUID()), new LocationAddress("Address1"),
                new LocationLatitude("00.000"), new LocationLongitude("00.000"), null);
        commandRepository.create(existingLocation);
    }

    @Test
    public void testCreate_shouldCallCommandRepositoryCreate() {
        domainLocationService.create(existingLocation);
        verify(commandRepository, times(2)).create(existingLocation);
    }

    @Test
    public void testUpdate_WithDifferentValues_ShouldUpdate() {
        // Arrange
        LocationId locationId = existingLocation.getId();
        Location updatedLocation = new Location(locationId, new LocationAddress("Address2"),
                new LocationLatitude("01.000"), new LocationLongitude("01.000"), null);
        when(queryRepository.findById(locationId)).thenReturn(existingLocation);
        assertEquals(existingLocation.getId(), updatedLocation.getId());
        domainLocationService.update(updatedLocation);
        verify(commandRepository, times(1)).update(existingLocation);
        assertEquals(existingLocation.toString(), updatedLocation.toString());
    }

    @Test
    public void delete_shouldCallCommandRepositoryDelete() {
        when(domainLocationService.findById(existingLocation.getId())).thenReturn(existingLocation);
        domainLocationService.delete(existingLocation.getId());
        verify(commandRepository, times(1)).delete(existingLocation);
    }

    @Test
    public void testFindByIdWithValidId() {
        LocationId validId = existingLocation.getId();
        when(queryRepository.findById(validId)).thenReturn(existingLocation);
        Location foundLocation = queryRepository.findById(validId);
        assertNotNull(foundLocation);
        assertEquals(validId, foundLocation.getId());
    }

    @Test
    public void testFindByIdWithInvalidId() {
        LocationId invalidId = new LocationId(UUID.randomUUID());
        when(queryRepository.findById(invalidId)).thenThrow(LocationNotFoundException.class);
        assertThrows(LocationNotFoundException.class, () -> queryRepository.findById(invalidId));
    }

    @Test
    public void testFindAllWithValidPageable() {
        Pageable pageable = Pageable.ofSize(20).withPage(0);
        Page<Location> expectedPage = new PageImpl<>(List.of(existingLocation));
        MessagePaginatedResponse expectedResponse =
                new MessagePaginatedResponse(List.of(existingLocation), expectedPage);
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