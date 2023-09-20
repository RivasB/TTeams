package ec.gob.registrocivil.identity.user.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ec.gob.registrocivil.identity.IdentityApplication;
import ec.gob.registrocivil.share.core.domain.service.IEventService;
import ec.gob.registrocivil.identity.user.domain.User;
import ec.gob.registrocivil.identity.user.domain.repository.IRegistrationTokenCommandRepository;
import ec.gob.registrocivil.identity.user.domain.repository.IRegistrationTokenQueryRepository;
import ec.gob.registrocivil.identity.user.domain.repository.IUserCommandRepository;
import ec.gob.registrocivil.identity.user.domain.repository.IUserQueryRepository;
import ec.gob.registrocivil.identity.user.domain.service.IPasswordEncoder;
import ec.gob.registrocivil.identity.user.domain.service.IUserService;
import ec.gob.registrocivil.identity.user.infrastructure.service.DomainUserService;

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
