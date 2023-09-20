package ec.gob.registrocivil.identity.validation_mesh.application.validate;

import java.util.Map;

public class ValidationRequest {

    // Subject of Request
    private String token;

    // Resource of Request
    private String path;

    // Action of Request
    private String method;

    // Environment of Request
    private Map<String, Object> env;

    public ValidationRequest(String token, String path, String method, Map<String, Object> env) {
        this.token = token;
        this.path = path;
        this.method = method;
        this.env = env;
    }

    public String getToken() {
        return token;
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }

    public Map<String, Object> getEnv() {
        return env;
    }

}
