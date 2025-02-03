package cloud.tteams.share.config.context;

import cloud.tteams.share.config.context.session.UserSession;

public class UserContext {
    private static final ThreadLocal<UserSession> userSession = new ThreadLocal<>();

    public static void setUserSession(UserSession session) {
        userSession.set(session);
    }

    public static UserSession getUserSession() {
        return userSession.get();
    }

    public static void clear() {
        userSession.remove();
    }
}
