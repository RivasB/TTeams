package cloud.tteams.share.config.context.filter;

import cloud.tteams.share.config.context.UserContext;
import cloud.tteams.share.config.context.session.UserSession;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Component
public class UserSessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String userIdHeader = httpRequest.getHeader("X-User-Id");
        String usernameHeader = httpRequest.getHeader("X-Username");
        if (userIdHeader != null && usernameHeader != null) {
            UUID userId = UUID.fromString(userIdHeader);
            UserSession userSession = new UserSession(userId, usernameHeader);
            UserContext.setUserSession(userSession);
        }
        else {
            UserSession userSession = new UserSession(UUID.randomUUID(), "anonymous/system");
            UserContext.setUserSession(userSession);
        }
        try {
            chain.doFilter(request, response);
        } finally {
            UserContext.clear();
        }
    }

    @Override
    public void destroy() {
    }
}