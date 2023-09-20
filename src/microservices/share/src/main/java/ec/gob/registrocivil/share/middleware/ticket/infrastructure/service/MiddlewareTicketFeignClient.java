package ec.gob.registrocivil.share.middleware.ticket.infrastructure.service;

import ec.gob.registrocivil.share.middleware.ticket.domain.TicketSIRQueryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "middleware", path = "/api/ticket", contextId = "ticket")
//@FeignClient(value = "http://localhost:8088", path = "/api/ticket", contextId = "ticket")
public interface MiddlewareTicketFeignClient {

    @GetMapping(path = "/consulta")
    TicketSIRQueryResponse consultaTicketSIR(@RequestParam(name = "paramIdTicket", required = true) String paramIdTicket);

}
