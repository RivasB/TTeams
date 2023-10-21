package cloud.tteams.project.project.domain.service;

import cloud.tteams.project.project.domain.*;
import cloud.tteams.project.project.domain.repository.IProjectCommandRepository;
import cloud.tteams.project.project.domain.repository.IProjectQueryRepository;
import cloud.tteams.project.project.infrastructure.exception.ProjectNotFoundException;
import cloud.tteams.project.project.infrastructure.service.ProjectDomainServiceImplementation;
import cloud.tteams.project.project.infrastructure.service.ProjectEventServiceImplementation;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProjectDomainServiceTest {
    private IProjectQueryRepository queryRepository;
    private IProjectCommandRepository commandRepository;
    private IProjectDomainService domainService;
    private Project existingProject;

    @Before
    public void setup() {
        queryRepository = mock(IProjectQueryRepository.class);
        commandRepository = mock(IProjectCommandRepository.class);
        ProjectEventServiceImplementation eventPublisher = mock(ProjectEventServiceImplementation.class);
        domainService = new ProjectDomainServiceImplementation(commandRepository, queryRepository, eventPublisher);
        existingProject = new Project(new ProjectId(UUID.randomUUID()), new ProjectName("Test Project"),
                new ProjectDescription("Test description"), new ProjectStartDate(LocalDate.now()),
                new ProjectEstimatedEndDate(LocalDate.now().plusMonths(3)), ProjectStatus.IN_PROGRESS,
                ProjectPriority.VERY_HIGH, new ProjectTags(), new ProjectComments(), new ProjectChangeLog(),
                new ProjectAttachments());
        commandRepository.create(existingProject);
    }

    @Test
    public void testCreate_shouldCallCommandRepositoryCreate() {
        domainService.create(existingProject);
        verify(commandRepository, times(2)).create(existingProject);
    }

    @Test
    public void testUpdate_WithDifferentValues_ShouldUpdate() {
        ProjectId projectId = existingProject.getId();
        Project updatedProject = new Project(projectId, new ProjectName("Updated Test Project"),
                new ProjectDescription("Updated Test description"), new ProjectStartDate(LocalDate.now()),
                new ProjectEstimatedEndDate(LocalDate.now().plusMonths(3)), ProjectStatus.COMPLETED,
                ProjectPriority.VERY_HIGH, new ProjectTags(), new ProjectComments(), new ProjectChangeLog(),
                new ProjectAttachments());
        when(queryRepository.findById(projectId)).thenReturn(existingProject);
        assertEquals(existingProject.getId(), updatedProject.getId());
        domainService.update(updatedProject);
        verify(commandRepository, times(1)).update(existingProject);
        assertEquals(existingProject.toString(), updatedProject.toString());
    }

    @Test
    public void delete_shouldCallCommandRepositoryDelete() {
        when(domainService.findById(existingProject.getId())).thenReturn(existingProject);
        domainService.delete(existingProject.getId());
        verify(commandRepository, times(1)).delete(existingProject.getId());
    }

    @Test
    public void testFindByIdWithValidId() {
        ProjectId validId = existingProject.getId();
        when(queryRepository.findById(validId)).thenReturn(existingProject);
        Project foundStation = queryRepository.findById(validId);
        assertNotNull(foundStation);
        assertEquals(validId, foundStation.getId());
    }

    @Test
    public void testFindByIdWithInvalidId() {
        ProjectId invalidId = new ProjectId(UUID.randomUUID());
        when(queryRepository.findById(invalidId)).thenThrow(ProjectNotFoundException.class);
        assertThrows(ProjectNotFoundException.class, () -> queryRepository.findById(invalidId));
    }

    @Test
    public void testFindAllWithValidPageable() {
        Pageable pageable = Pageable.ofSize(20).withPage(0);
        Page<Project> expectedPage = new PageImpl<>(List.of(existingProject));
        MessagePaginatedResponse expectedResponse =
                new MessagePaginatedResponse(List.of(existingProject), expectedPage);
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