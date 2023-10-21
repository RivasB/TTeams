package cloud.tteams.share.email.infrastructure.service;

import cloud.tteams.share.core.infrastructure.util.FileMultipartFile;
import cloud.tteams.share.email.domain.service.IEmailServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
class EmailServiceClient implements IEmailServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceClient.class);

    private final MiddlewareMailFeignClient mailFeignClient;

    EmailServiceClient(MiddlewareMailFeignClient mailFeignClient) {
        this.mailFeignClient = mailFeignClient;
    }

    @Override
    public boolean sendSimpleEmail(String toEmail, String subject, String message) {
        try {
            FeignMailSimpleRequest request = new FeignMailSimpleRequest(toEmail, subject, message);
            FeignMailResponse response = mailFeignClient.sendSimpleEmail(request);
            return response.status();
        } catch (Exception ex) {
            logger.error("Error sending a simple text email: ", ex);
            return false;
        }
    }

    @Override
    public boolean sendTemplateEmail(String toEmail, String subject, String message) {
        try {
            FeignMailSimpleRequest request = new FeignMailSimpleRequest(toEmail, subject, message);
            FeignMailResponse response = mailFeignClient.sendTemplateEmail(request);
            return response.status();
        } catch (Exception ex) {
            logger.error("Error sending the email with template: ", ex);
            return false;
        }
    }

    @Override
    public boolean sendAttachmentEmail(String toEmail, String subject, String message, File attachment) {
        try {
            FileInputStream inputStream = new FileInputStream(attachment);
            FileMultipartFile multipartFile = new FileMultipartFile(attachment.getName(), inputStream);
            FeignMailResponse response = mailFeignClient.sendAttachmentEmail(toEmail, subject, message, multipartFile);
            return response.status();
        } catch (IOException ex) {
            logger.error("Error sending the email with attachment: ", ex);
            return false;
        } catch (Exception ex) {
            logger.error("Error in the with attachment: ", ex);
            return false;
        }
    }
}
