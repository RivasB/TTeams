package cloud.tteams.share.email.domain.service;

import java.io.File;

public interface IEmailServiceClient {

    boolean sendSimpleEmail(String toEmail, String subject, String message);

    boolean sendTemplateEmail(String toEmail, String subject, String message);

    boolean sendAttachmentEmail(String toEmail, String subject, String message, File attachment);

}