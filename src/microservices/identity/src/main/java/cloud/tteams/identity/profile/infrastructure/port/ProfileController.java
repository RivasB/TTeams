package cloud.tteams.identity.profile.infrastructure.port;

import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cloud.tteams.identity.profile.application.command.create.CreateProfileCommand;
import cloud.tteams.identity.profile.application.command.create.CreateProfileMessage;
import cloud.tteams.identity.profile.application.command.create.CreateProfileRequest;
import cloud.tteams.identity.profile.application.command.delete.DeleteProfileCommand;
import cloud.tteams.identity.profile.application.command.delete.DeleteProfileMessage;
import cloud.tteams.identity.profile.application.command.update.UpdateProfileCommand;
import cloud.tteams.identity.profile.application.command.update.UpdateProfileMessage;
import cloud.tteams.identity.profile.application.command.update.UpdateProfileRequest;
import cloud.tteams.identity.profile.application.query.getall.FindProfileWithFilterQuery;
import cloud.tteams.identity.profile.application.query.getbyid.FindProfileByIdQuery;
import cloud.tteams.identity.profile.application.query.getbyid.FindProfileByIdResponse;
import cloud.tteams.share.core.application.ApiResponse2xx;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/profile")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Profile", description = "The Profile API. Contains all the operations that can be performed on a profile.")
public class ProfileController {

    private final IMediator mediator;

    public ProfileController(IMediator mediator) {
        this.mediator = mediator;
    }

    // This workflow is implemented by 06-RFS5. Gestionar Perfil
    @PostMapping
    public ResponseEntity<ApiResponse2xx<CreateProfileMessage>> createProfile(
            @RequestBody CreateProfileRequest request) {

        CreateProfileCommand createCommand = CreateProfileCommand.fromRequest(request);
        CreateProfileMessage response = mediator.send(createCommand);

        return ResponseEntity.ok(new ApiResponse2xx<CreateProfileMessage>(response, HttpStatus.CREATED));
    }

    // This workflow is implemented by 06-RFS5. Gestionar Perfil
    @PutMapping
    public ResponseEntity<ApiResponse2xx<UpdateProfileMessage>> updateProfile(
            @RequestBody UpdateProfileRequest request) {

        UpdateProfileCommand updateCommand = UpdateProfileCommand.fromRequest(request);
        UpdateProfileMessage response = mediator.send(updateCommand);

        return ResponseEntity.ok(new ApiResponse2xx<UpdateProfileMessage>(response, HttpStatus.OK));
    }

    // This workflow is implemented by 06-RFS5. Gestionar Perfil
    @GetMapping
    public ResponseEntity<MessagePaginatedResponse> getAllProfiles(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "") String filter,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortType,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "state", required = false) ProfileState state,
            @RequestParam(name = "agencyId", required = false) UUID agencyId) {
        Sort sort = (sortType.equals("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        FindProfileWithFilterQuery query = new FindProfileWithFilterQuery(pageable, filter, name, description, state, agencyId);
        MessagePaginatedResponse pageResponse = mediator.send(query);

        return ResponseEntity.ok(pageResponse);
    }

    // This workflow is implemented by 06-RFS5. Gestionar Perfil
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<DeleteProfileMessage>> deleteAgency(@NotBlank @PathVariable UUID id) {

        DeleteProfileCommand deleteCommand = new DeleteProfileCommand(id);
        DeleteProfileMessage response = mediator.send(deleteCommand);

        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }

    // This workflow is implemented by 06-RFS5. Gestionar Perfil
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<FindProfileByIdResponse>> getProfile(@NotBlank @PathVariable UUID id) {

        FindProfileByIdQuery query = new FindProfileByIdQuery(id);
        FindProfileByIdResponse response = mediator.send(query);

        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
    }
}
