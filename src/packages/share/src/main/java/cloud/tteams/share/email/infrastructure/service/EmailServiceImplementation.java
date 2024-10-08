package cloud.tteams.share.email.infrastructure.service;

import cloud.tteams.share.email.domain.service.IEmailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
class EmailServiceImplementation implements IEmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImplementation.class);

    private final JavaMailSender emailSender;

    private final TemplateEngine templateEngine;

    EmailServiceImplementation(JavaMailSender emailSender, TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendSimpleOTPEmail(String to, String subject, String otp) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            Context context = new Context();
            context.setVariable("otpCode", otp);
            String htmlContent = templateEngine.process("otp-email-template.html", context);
            helper.setText(htmlContent, true);
            emailSender.send(message);
            logger.info("OTP email sent to {}", to);
        }catch (MessagingException exception){
            logger.error("OTP email sending failed", exception);
        }

    }
}
