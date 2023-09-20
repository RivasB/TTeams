package ec.gob.registrocivil.share.middleware.notification.infrastructure.service;

import ec.gob.registrocivil.share.middleware.notification.domain.Mail;
import ec.gob.registrocivil.share.middleware.notification.domain.MailResponse;
import ec.gob.registrocivil.share.middleware.notification.domain.service.IMiddlewareNotificationServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MiddlewareNotificationServiceClient implements IMiddlewareNotificationServiceClient {
    private final MiddlewareNotificationFeignClient client;

    private static final Logger logger = LoggerFactory.getLogger(MiddlewareNotificationServiceClient.class);

    public MiddlewareNotificationServiceClient(MiddlewareNotificationFeignClient client) {
        this.client = client;
    }

    @Override
    public MailResponse sendMail(Mail mail) {
        try{
            return client.sendMail(mail);
        }catch (Exception e){
            logger.error("Error send mail: ", e);
            return null;
        }
    }
}
