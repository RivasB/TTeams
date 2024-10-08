package cloud.tteams.identity.security.infrastructure.filter;

import java.io.IOException;

import cloud.tteams.identity.security.domain.service.utility.IJavaWebTokenService;
import cloud.tteams.identity.security.infrastructure.service.utility.JavaWebTokenServiceImplementation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JavaWebTokenRequestFilter extends OncePerRequestFilter {

    private final IJavaWebTokenService javaWebTokenService;
    private final UserDetailsService userDetailsService;

    public JavaWebTokenRequestFilter(JavaWebTokenServiceImplementation javaWebTokenService, UserDetailsService userDetailsService) {
        this.javaWebTokenService = javaWebTokenService;
        this.userDetailsService = userDetailsService;
    }

    @Value("${security.jwt.header.string}")
    public String headerString;

    @Value("${security.jwt.token.prefix}")
    public String tokenPrefix;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader(headerString);

        String email = null;
        String jwtToken = null;
        // JWT Token is in the form "Bearer token". Remove Bearer word and get
        // only the Token
        if (requestTokenHeader != null && requestTokenHeader.startsWith(tokenPrefix)) {
            jwtToken = requestTokenHeader.replace(tokenPrefix + " ", "");
            try {
                email = javaWebTokenService.getValue(jwtToken);
            } catch (IllegalArgumentException e) {
                logger.error("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                logger.error("JWT Token has expired");
            }
        } else {
            logger.warn("JWT Token does not begin with Bearer String");
        }

        // Once we get the token validate it.
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            // if token is valid configure Spring Security to manually set
            // authentication
            if (javaWebTokenService.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // After setting the Authentication in the context, we specify
                // that the current user is authenticated. So it passes the
                // Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                logger.info("User trying to login as: " + email + ", now is authenticated");
            }
        }
        filterChain.doFilter(request, response);
    }
}
