package ec.gob.registrocivil.share.payment.infrastructure.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import ec.gob.registrocivil.share.middleware.ticket.domain.TicketSIRQueryResponse;
import ec.gob.registrocivil.share.middleware.ticket.infrastructure.service.MiddlewareTicketServiceClient;
import ec.gob.registrocivil.share.payment.domain.service.IPaymentServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
class PaymentServiceClient implements IPaymentServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceClient.class);

    private final PlacetoPayFeignClient placetoPayFeignClient;
    
    private final MiddlewareTicketServiceClient middlewareTicketServiceClient;

    private final ObjectReader jsonReader;

    public PaymentServiceClient(PlacetoPayFeignClient placetoPayFeignClient, MiddlewareTicketServiceClient middlewareTicketServiceClient) {
        this.placetoPayFeignClient = placetoPayFeignClient;
        this.middlewareTicketServiceClient = middlewareTicketServiceClient;
        jsonReader = new ObjectMapper().reader();
    }

    @Override
    public boolean checkPlaceToPayPayment(String paymentCode, String civilRegistrationId) {
        try {
            ResponseEntity<String> response = placetoPayFeignClient.checkPayment(civilRegistrationId, paymentCode);
            JsonNode jsonResponse = jsonReader.readTree(response.getBody());
            return Objects.equals("APPROVED", jsonResponse.path("currentStatus").asText());
        } catch (Exception ex) {
            logger.error("Error checking payment in PlacetoPay: ", ex);
            return false;
        }
    }

    @Override
    public boolean checkCorrespondentPayment(String paymentCode) {
        TicketSIRQueryResponse response = middlewareTicketServiceClient.consultaTicketSIR(paymentCode);
        return response.getTicketSIR() != null;
    }
}
