package ec.gob.registrocivil.share.middleware.notification.infrastructure.service;


import ec.gob.registrocivil.share.middleware.notification.domain.Mail;
import ec.gob.registrocivil.share.middleware.notification.domain.MailResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "middleware", path = "/api" , contextId = "notificaciones")
public interface MiddlewareNotificationFeignClient {

    @PostMapping(path = "/enviar/email")
    MailResponse sendMail(@RequestBody Mail mail);
}
