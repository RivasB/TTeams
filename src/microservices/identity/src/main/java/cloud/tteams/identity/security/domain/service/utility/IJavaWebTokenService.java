package cloud.tteams.identity.security.domain.service.utility;

import io.jsonwebtoken.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Date;
import java.util.function.Function;

public interface IJavaWebTokenService {
    String create(UserDetails user);

    String getValue(String jwt);

    String getKey(String jwt);

    boolean getEnabled(String jwt);

    boolean validateToken(String token, UserDetails userDetails);

    Date getExpirationDateFromToken(String token);

    <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);

    boolean validateAuthToken(String token);

    String getIdentification(String requestTokenHeader);

    String refreshAuthToken(@NotBlank String token);
}
