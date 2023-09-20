package ec.gob.registrocivil.share.payment.domain.service;

public interface IPaymentServiceClient {

    boolean checkPlaceToPayPayment(String paymentCode, String civilRegistrationId);

    boolean checkCorrespondentPayment(String paymentCode);

}
