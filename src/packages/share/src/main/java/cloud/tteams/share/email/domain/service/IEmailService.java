package cloud.tteams.share.email.domain.service;

public interface IEmailService {

    void sendSimpleOTPEmail(String toEmail, String subject, String message);

}