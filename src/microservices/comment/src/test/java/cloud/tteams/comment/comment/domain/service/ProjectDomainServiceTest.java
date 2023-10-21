package cloud.tteams.comment.comment.domain.service;

import cloud.tteams.comment.comment.domain.*;
import cloud.tteams.comment.comment.infrastructure.service.ProjectDomainServiceImplementation;
import cloud.tteams.project.project.domain.*;
import cloud.tteams.comment.comment.domain.repository.ICommentCommandRepository;
import cloud.tteams.comment.comment.domain.repository.ICommentQueryRepository;
import cloud.tteams.comment.comment.infrastructure.exception.CommentNotFoundException;
import cloud.tteams.comment.comment.infrastructure.service.ProjectEventServiceImplementation;
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
    private ICommentQueryRepository queryRepository;
    private ICommentCommandRepository commandRepository;
    private ICommentDomainService domainService;
    private Comment existingProject;

    @Before
    public void setup() {
        queryRepository = mock(ICommentQueryRepository.class);
        commandRepository = mock(ICommentCommandRepository.class);
        ProjectEventServiceImplementation eventPublisher = mock(ProjectEventServiceImplementation.class);
        domainService = new ProjectDomainServiceImplementation(commandRepository, queryRepository, eventPublisher);
        existingProject = new Comment(new CommentId(UUID.randomUUID()), new CommentTextBody("Test Project"),
                new ProjectDescription("Test description"), new CommentCreatedAt(LocalDate.now()),
                new ProjectEstimatedEndDate(LocalDate.now().plusMonths(3)), CommentAssociatedEntityType.IN_PROGRESS,
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
        CommentId projectId = existingProject.getId();
        Comment updatedProject = new Comment(projectId, new CommentTextBody("Updated Test Project"),
                new ProjectDescription("Updated Test description"), new CommentCreatedAt(LocalDate.now()),
                new ProjectEstimatedEndDate(LocalDate.now().plusMonths(3)), CommentAssociatedEntityType.COMPLETED,
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
        CommentId validId = existingProject.getId();
        when(queryRepository.findById(validId)).thenReturn(existingProject);
        Comment foundStation = queryRepository.findById(validId);
        assertNotNull(foundStation);
        assertEquals(validId, foundStation.getId());
    }

    @Test
    public void testFindByIdWithInvalidId() {
        CommentId invalidId = new CommentId(UUID.randomUUID());
        when(queryRepository.findById(invalidId)).thenThrow(CommentNotFoundException.class);
        assertThrows(CommentNotFoundException.class, () -> queryRepository.findById(invalidId));
    }

    @Test
    public void testFindAllWithValidPageable() {
        Pageable pageable = Pageable.ofSize(20).withPage(0);
        Page<Comment> expectedPage = new PageImpl<>(List.of(existingProject));
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