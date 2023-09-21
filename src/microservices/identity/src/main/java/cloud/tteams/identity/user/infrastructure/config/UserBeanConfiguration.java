package cloud.tteams.identity.user.infrastructure.config;

import cloud.tteams.identity.user.infrastructure.service.DomainUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cloud.tteams.identity.IdentityApplication;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.identity.user.domain.User;
import cloud.tteams.identity.user.domain.repository.IRegistrationTokenCommandRepository;
import cloud.tteams.identity.user.domain.repository.IRegistrationTokenQueryRepository;
import cloud.tteams.identity.user.domain.repository.IUserCommandRepository;
import cloud.tteams.identity.user.domain.repository.IUserQueryRepository;
import cloud.tteams.identity.user.domain.service.IPasswordEncoder;
import cloud.tteams.identity.user.domain.service.IUserService;

@Configuration
@ComponentScan(basePackageClasses = IdentityApplication.class)
public class UserBeanConfiguration {

    @Bean
    public IUserService userService(
            final IUserCommandRepository commandRepository,
            final IUserQueryRepository queryRepository,
            final IPasswordEncoder encoder,
            final IEventService<User> eventService,
            final IRegistrationTokenCommandRepository registrationCommandRepository,
            final IRegistrationTokenQueryRepository registrationQueryRepository) {

        return new DomainUserService(commandRepository, queryRepository, encoder, eventService,
                registrationCommandRepository, registrationQueryRepository);
    }

    @Bean
    public BCryptPasswordEncoder beanPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}
