package ec.gob.registrocivil.share.middleware.ticket.infrastructure.service;

import ec.gob.registrocivil.share.middleware.ticket.domain.TicketSIRQueryResponse;
import ec.gob.registrocivil.share.middleware.ticket.domain.service.IMiddlewareTicketServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MiddlewareTicketServiceClient implements IMiddlewareTicketServiceClient {

    private final MiddlewareTicketFeignClient client;
    private static final Logger logger = LoggerFactory.getLogger(MiddlewareTicketServiceClient.class);

    public MiddlewareTicketServiceClient(MiddlewareTicketFeignClient client) {
        this.client = client;
    }

    @Override
    public TicketSIRQueryResponse consultaTicketSIR(String paramIdTicket) {
        try{
            return client.consultaTicketSIR(paramIdTicket);
        }catch (Exception e){
            logger.error("Error consulting ticket: ", e);
            return null;
        }
    }
}
