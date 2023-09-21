package cloud.tteams.gateway.share.infrastructure.conf;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
public class PermissionFilter extends AbstractGatewayFilterFactory<PermissionFilter.Config> {
    private WebClient.Builder webClient;

    public PermissionFilter(WebClient.Builder webClient) {
        super(Config.class);
        this.webClient = webClient;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // TODO: Pre-processing
            System.out.println("PermissionFilter acting!!");
            ServerHttpRequest request = exchange.getRequest();

            String tokenHeader = Objects.requireNonNull(request.getHeaders().get(HttpHeaders.AUTHORIZATION)).get(0);

            // obtener usuario logueado lb://identity/api/user/me

            //Obtener permisos del usuario lb://identity/api/api/validation
            // comprobar si el recurso solicitado coincide con el permiso en true
            // - si no coincide denegar el acceso al recurso.


            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        // TODO: Post-processing
                    }));
        };
    }

    private Mono<Void> onError(ServerWebExchange exchange, HttpStatus status) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(status);

        return response.setComplete();
    }

    public static class Config {

        private String endpoint = "lb://identity/api/auth/permission";

        public Config() {
        }

        public Config(String endpoint) {
            this.endpoint = endpoint;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public void setEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }
    }
}
