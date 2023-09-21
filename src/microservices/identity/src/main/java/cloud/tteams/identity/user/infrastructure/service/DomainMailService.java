package cloud.tteams.identity.user.infrastructure.service;

import cloud.tteams.identity.user.domain.service.IMailService;
import cloud.tteams.share.email.domain.service.IEmailServiceClient;
import org.springframework.stereotype.Component;

@Component
public class DomainMailService implements IMailService {

    private final IEmailServiceClient emailService;

    public DomainMailService(final IEmailServiceClient emailService) {
        this.emailService = emailService;
    }

    @Override
    public boolean sendMail(String toEmail, String subject, String message) {
        this.emailService.sendSimpleEmail(toEmail, subject, message);
        return true;
    }
}
