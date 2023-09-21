package cloud.tteams.identity.security.infrastructure.port;

import cloud.tteams.share.core.infrastructure.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cloud.tteams.identity.security.application.authenticate.AuthenticateUserRequest;
import cloud.tteams.identity.security.application.authenticate.AuthenticateUserResponse;
import cloud.tteams.identity.security.application.authenticate.ValidateTokenRequest;
import cloud.tteams.identity.security.domain.service.JwtTokenManager;
import cloud.tteams.share.core.application.ApiResponse2xx;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
@Tag(name = "Authenticate", description = "The Authentication API. Contains all the operations for authentication management.")
public class AuthController {

	@Value("${security.jwt.ttlMillis}")
	private long ttlMillis;

	private final AuthenticationManager authenticationManager;
	private final JwtTokenManager jwTokenManager;
	private final UserDetailsService userDetailsService;

	public AuthController(AuthenticationManager authenticationManager, JwtTokenManager jwTokenManager,
			UserDetailsService userDetailsService) {
		this.authenticationManager = authenticationManager;
		this.jwTokenManager = jwTokenManager;
		this.userDetailsService = userDetailsService;
	}

	@PostMapping("/login")
	public ResponseEntity<ApiResponse2xx<AuthenticateUserResponse>> createAuthenticationToken(
			@RequestBody AuthenticateUserRequest authenticationRequest) throws UnauthorizedException {
		authenticate(authenticationRequest.getIdentification(), authenticationRequest.getPassword());
		UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getIdentification());
		final String token = jwTokenManager.create(userDetails);
		AuthenticateUserResponse response = new AuthenticateUserResponse(token, ttlMillis);
		return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
	}

	@PostMapping("/validate")
	public ResponseEntity<?> validateAuthenticationToken(@NotBlank @RequestParam String token) {
		boolean validated = jwTokenManager.validateAuthToken(token);
		ValidateTokenRequest response = new ValidateTokenRequest(token);
		return ResponseEntity.ok(
				validated ? new ApiResponse2xx<>(response, HttpStatus.OK) : HttpStatus.FORBIDDEN);
	}

	@PostMapping("/refresh")
	public ResponseEntity<ApiResponse2xx<AuthenticateUserResponse>> refreshAuthenticationToken(
			@NotBlank @RequestParam String token) {
		final String refreshedToken = jwTokenManager.refreshAuthToken(token);
		AuthenticateUserResponse response = new AuthenticateUserResponse(refreshedToken, ttlMillis);
		return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.OK));
	}

	private void authenticate(String identification, String password)
			throws UnauthorizedException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(identification, password));
		} catch (DisabledException e) {
			throw new UnauthorizedException("User disabled");
		} catch (Exception e) {
			throw new UnauthorizedException("Bad Credentials");
		}
	}
}
