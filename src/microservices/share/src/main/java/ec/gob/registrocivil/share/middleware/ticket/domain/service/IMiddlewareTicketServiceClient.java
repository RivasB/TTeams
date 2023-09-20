package ec.gob.registrocivil.share.middleware.ticket.domain.service;

import ec.gob.registrocivil.share.middleware.ticket.domain.TicketSIRQueryResponse;

public interface IMiddlewareTicketServiceClient {
    
    TicketSIRQueryResponse consultaTicketSIR(String paramIdTicket);
}
