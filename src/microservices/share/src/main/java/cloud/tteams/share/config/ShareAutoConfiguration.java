package cloud.tteams.share.config;

import cloud.tteams.share.core.infrastructure.bus.IMediator;
import feign.Feign;
import feign.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.TimeUnit;


@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(IMediator.class)
public class ShareAutoConfiguration {

    @Value("${rc.microservice.feign.connect-timeout:30000}")
    private Long feignConnectTimeout;

    @Value("${rc.microservice.feign.read-timeout:30000}")
    private Long feignReadTimeout;

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        Request.Options option = new Request.Options(feignConnectTimeout, TimeUnit.MILLISECONDS, feignReadTimeout,
                TimeUnit.MILLISECONDS, false);
        return Feign.builder().options(option);
    }
}
