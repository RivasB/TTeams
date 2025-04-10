package cloud.tteams.share.config.context.session;

import java.util.UUID;

public class UserSession {
    private UUID userId;
    private String username;
    private String userRole;

    public UserSession(UUID userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
