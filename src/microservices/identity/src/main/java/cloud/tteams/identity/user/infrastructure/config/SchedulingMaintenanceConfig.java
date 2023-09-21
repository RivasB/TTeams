package cloud.tteams.identity.user.infrastructure.config;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;

import cloud.tteams.identity.user.domain.RegistrationTokenDateTime;
import cloud.tteams.identity.user.domain.repository.IRegistrationTokenCommandRepository;

@Configuration
@EnableScheduling
public class SchedulingMaintenanceConfig implements SchedulingConfigurer {

    private class RegistrationTokenCleanTriggerTask extends TriggerTask {

        public RegistrationTokenCleanTriggerTask() {
            super(() -> {
                // Exec this task
                RegistrationTokenDateTime current = new RegistrationTokenDateTime(
                        LocalDateTime.now().minusMinutes(REGISTRATION_TOKEN_EXPIRE_THRESHOLD));
                registrationCommandRepository.deleteAllByEndingDateTimeBefore(current);
            }, triggerContext -> {
                // Triggered here
                Instant lastCompletion = Optional.ofNullable(triggerContext.lastCompletion())
                        .orElse(Instant.now());

                // convert minutes to millis
                return lastCompletion
                        .plusMillis(60000L * (REGISTRATION_TOKEN_EXPIRE + REGISTRATION_TOKEN_EXPIRE_THRESHOLD));
            });
        }
    }

    /**
     * REGISTRATION_TOKEN_EXPIRE configuration variable,
     * time in minutes after witch Validation Token will expire.
     *
     * <p>
     * Default: 5 minutes
     */
    @Value("${user.validation.expire:5}")
    private int REGISTRATION_TOKEN_EXPIRE;

    /**
     * REGISTRATION_TOKEN_EXPIRE_THRESHOLD configuration variable,
     * time in minutes after witch Validation Token Expired will be deleted.
     *
     * <p>
     * Default: 30 minutes
     */
    @Value("${user.validation.expire.threshold:30}")
    private int REGISTRATION_TOKEN_EXPIRE_THRESHOLD;

    private final IRegistrationTokenCommandRepository registrationCommandRepository;

    public SchedulingMaintenanceConfig(IRegistrationTokenCommandRepository registrationCommandRepository) {
        this.registrationCommandRepository = registrationCommandRepository;
    }

    @Bean
    public Executor taskExecutor() {
        return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());

        taskRegistrar.addTriggerTask(new RegistrationTokenCleanTriggerTask());
    }
}
