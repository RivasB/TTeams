package cloud.tteams.share.email.infrastructure.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(value = "middlewaremail", path = "/api/mail")
interface MiddlewareMailFeignClient {

    @PostMapping(path = "/send/simple")
    FeignMailResponse sendSimpleEmail(FeignMailSimpleRequest request);

    @PostMapping(path = "/send/template")
    FeignMailResponse sendTemplateEmail(FeignMailSimpleRequest request);

    @RequestMapping(method = RequestMethod.POST, path = "/send/attachment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    FeignMailResponse sendAttachmentEmail(@RequestParam("email") String toEmail,
                                          @RequestParam("subject") String subject,
                                          @RequestParam("menssage") String message,
                                          @RequestPart("file") MultipartFile file);

}
