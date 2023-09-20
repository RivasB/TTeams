package ec.gob.registrocivil.share.middleware.notification.domain.service;

import ec.gob.registrocivil.share.middleware.notification.domain.Mail;
import ec.gob.registrocivil.share.middleware.notification.domain.MailResponse;

public interface IMiddlewareNotificationServiceClient {
    MailResponse sendMail(Mail mail);
}
