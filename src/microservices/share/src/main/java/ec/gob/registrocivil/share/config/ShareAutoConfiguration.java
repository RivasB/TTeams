package ec.gob.registrocivil.share.config;

import ec.gob.registrocivil.share.core.infrastructure.bus.IMediator;
import feign.Feign;
import feign.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.TimeUnit;


@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(IMediator.class)
@ComponentScan(basePackages = "ec.gob.registrocivil.share")
@EnableFeignClients(basePackages = {
        "ec.gob.registrocivil.share.payment.infrastructure",
        "ec.gob.registrocivil.share.email.infrastructure",
        "ec.gob.registrocivil.share.middleware.nui.infrastructure",
        "ec.gob.registrocivil.share.holiday.infrastructure",
        "ec.gob.registrocivil.share.middleware.receipt.infrastructure",
        "ec.gob.registrocivil.share.middleware.suri.infrastructure",
        "ec.gob.registrocivil.share.middleware.notification.infrastructure",
        "ec.gob.registrocivil.share.middleware.actregistration.infrastructure",
        "ec.gob.registrocivil.share.middleware.ticket.infrastructure",
        "ec.gob.registrocivil.share.middleware.certificationsimple.infrastructure"
})
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
