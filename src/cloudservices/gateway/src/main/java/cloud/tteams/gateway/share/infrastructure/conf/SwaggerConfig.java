package cloud.tteams.gateway.share.infrastructure.conf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springdoc.core.AbstractSwaggerUiConfigProperties;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springdoc.core.SwaggerUiConfigProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class SwaggerConfig implements WebFluxConfigurer {

    public Set<AbstractSwaggerUiConfigProperties.SwaggerUrl> urls(RouteDefinitionLocator locator) {
        Set<AbstractSwaggerUiConfigProperties.SwaggerUrl> urls = new HashSet<>();
        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
        assert definitions != null;
        definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-swagger-ui"))
                .forEach(routeDefinition -> {
                    AbstractSwaggerUiConfigProperties.SwaggerUrl url = new AbstractSwaggerUiConfigProperties.SwaggerUrl();
                    String name = routeDefinition.getId().replaceAll("-swagger-ui", "");
                    url.setName(name);
                    url.setUrl("lb://" + name + "/v3/api-docs");
                    urls.add(url);
                });
        return urls;
    }

    @Bean
    public SwaggerUiConfigParameters swaggerUiConfigParameters(RouteDefinitionLocator locator) {
        SwaggerUiConfigProperties properties = new SwaggerUiConfigProperties();
        properties.setDisableSwaggerDefaultUrl(true);
        properties.setUrls(this.urls(locator));
        return new SwaggerUiConfigParameters(properties);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
                .resourceChain(false);
    }
}
