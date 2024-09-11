package cloud.tteams.identity.security.infrastructure.service.utility;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.crypto.spec.SecretKeySpec;

import cloud.tteams.identity.security.domain.rules.TokenRefreshEligibility;
import cloud.tteams.identity.security.domain.service.utility.IJavaWebTokenService;
import cloud.tteams.share.core.domain.rules.RulesChecker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.validation.constraints.NotBlank;
import jakarta.xml.bind.DatatypeConverter;

@Component
public class JavaWebTokenServiceImplementation implements IJavaWebTokenService {

    @Value("${security.jwt.secret}")
    private String key;

    @Value("${security.jwt.issuer}")
    private String issuer;

    @Value("${security.jwt.ttlMillis}")
    private long ttlMillis;

    @Value("${security.jwt.authorities.key}")
    public String authoritiesKey;

    private final UserDetailsService userDetailsService;

    public JavaWebTokenServiceImplementation(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * Create a new token.
     *
     * @return token
     */
    @Override
    public String create(UserDetails user) {

        // The JWT signature algorithm used to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        String authorities = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        // sign JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // set the JWT Claims
        JwtBuilder builder = Jwts.builder().setIssuedAt(now).setSubject(user.getUsername()).setIssuer(issuer)
                .claim(authoritiesKey, authorities)
                .signWith(signingKey, signatureAlgorithm);

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        // Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    /**
     * Method to validate and read the JWT
     *
     */
    @Override
    public String getValue(String jwt) {
        // This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(key)).build()
                .parseClaimsJws(jwt).getBody();
        return claims.getSubject();
    }

    /**
     * Method to validate and read the JWT
     *
     */
    @Override
    public String getKey(String jwt) {
        // This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(key)).build()
                .parseClaimsJws(jwt).getBody();
        return claims.getId();
    }

    /**
     * Method to validate and read the JWT
     *
     */
    @Override
    public boolean getEnabled(String jwt) {
        // This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(key)).build()
                .parseClaimsJws(jwt).getBody();
        return (boolean) claims.get("enabled");
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = getValue(token);
        return (username.equals(userDetails.getUsername()) && isTokenActive(token));
    }

    private boolean validateToken(String token) {
        return !getValue(token).isEmpty() && isTokenActive(token);
    }

    // check if the token has expired
    private boolean isTokenActive(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return !expiration.before(new Date());
    }

    // retrieve expiration date from jwt token
    @Override
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    @Override
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // for retrieving any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(DatatypeConverter.parseBase64Binary(key)).build()
                .parseClaimsJws(token).getBody();
    }

    @Override
    public boolean validateAuthToken(String token) {
        return validateToken(token);
    }

    @Override
    public String getEmail(String requestTokenHeader) {
        String email;
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer")) {
            String token = requestTokenHeader.replace("Bearer" + " ", "");
            try {
                email = getValue(token);
            } catch (IllegalArgumentException e) {
                throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Invalid credentials", e);
            } catch (ExpiredJwtException e) {
                throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Session expired", e);
            }
        } else {
            email = getValue(requestTokenHeader);
        }
        return email;
    }

    @Override
    public String refreshAuthToken(@NotBlank String token) {
        UserDetails user;
        String refreshedToken;
        RulesChecker.checkRule(new TokenRefreshEligibility(new Date(),
                this.getExpirationDateFromToken(token)));
        try {
            String email = this.getValue(token);
            user = userDetailsService.loadUserByUsername(email);
            refreshedToken = this.create(user);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Logged off. Please login again!", e);
        }
        return refreshedToken;
    }
}
