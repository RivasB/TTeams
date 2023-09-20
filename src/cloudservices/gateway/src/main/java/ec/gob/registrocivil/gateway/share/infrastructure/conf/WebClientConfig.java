package ec.gob.registrocivil.gateway.share.infrastructure.conf;

import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    DefaultErrorWebExceptionHandler a;

    @Bean
    @LoadBalanced
    public WebClient.Builder builder() {
        return WebClient.builder();
    }

}
