package cloud.tteams.identity.user.domain.service;

public interface IMailService {
    public boolean sendMail(String toEmail, String subject, String message);
}
