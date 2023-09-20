package ec.gob.registrocivil.share.payment.infrastructure.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "payment-placetopay", url = "https://payment.registro-civil.ddns.net/placetopay")
interface PlacetoPayFeignClient {

    /**
     * Call the PlacetoPay payment for a checkout
     * TODO Review PlacetoPay payment
     * @param paymentCode : the payment code
     * @return : a json value
     */
    @RequestMapping(value = "/{civilRegistrationId}/transactions/{paymentCode}",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> checkPayment(@PathVariable("civilRegistrationId") String civilRegistrationId, @PathVariable("paymentCode") String paymentCode);
}
