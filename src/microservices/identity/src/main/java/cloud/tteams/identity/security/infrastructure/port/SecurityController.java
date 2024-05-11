package cloud.tteams.identity.security.infrastructure.port;

import cloud.tteams.identity.security.application.login.LoginQuery;
import cloud.tteams.identity.security.application.refresh.RefreshQuery;
import cloud.tteams.identity.security.application.validate.ValidateQuery;
import cloud.tteams.share.core.infrastructure.bus.IMediator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cloud.tteams.identity.security.application.login.LoginRequest;
import cloud.tteams.identity.security.application.JavaWebTokenResponse;
import cloud.tteams.share.core.application.ApiResponse2xx;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
@Tag(name = "Authenticate", description = "The Authentication API. Contains all the operations for authentication management.")
public class SecurityController {

	private final IMediator mediator;

	public SecurityController(IMediator mediator) {
		this.mediator = mediator;
	}

	@PostMapping("/login")
	public ResponseEntity<ApiResponse2xx<JavaWebTokenResponse>> login(
			@RequestBody LoginRequest request){
		LoginQuery query = new LoginQuery(request);
		JavaWebTokenResponse response = mediator.send(query);
		return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
	}

	@PostMapping("/validate")
	public ResponseEntity<ApiResponse2xx<JavaWebTokenResponse>> validate(@NotBlank @RequestParam String token) {
		ValidateQuery query = new ValidateQuery(token);
		JavaWebTokenResponse response = mediator.send(query);
		return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
	}

	@PostMapping("/refresh")
	public ResponseEntity<ApiResponse2xx<JavaWebTokenResponse>> refresh(@NotBlank @RequestParam String token) {
		RefreshQuery query = new RefreshQuery(token);
		JavaWebTokenResponse response = mediator.send(query);
		return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
	}
}
