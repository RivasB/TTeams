package ec.gob.registrocivil.share.middleware.receipt.infrastructure.service;

import ec.gob.registrocivil.share.middleware.receipt.domain.Receipt;
import ec.gob.registrocivil.share.middleware.receipt.domain.ReceiptBill;
import ec.gob.registrocivil.share.middleware.receipt.domain.ReceiptInfo;
import ec.gob.registrocivil.share.middleware.receipt.domain.service.IMiddlewareReceiptServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class MiddlewareReceiptServiceClient implements IMiddlewareReceiptServiceClient {
    private final MiddlewareReceiptFeignClient feignClient;

    private static final Logger logger = LoggerFactory.getLogger(MiddlewareReceiptServiceClient.class);

    public MiddlewareReceiptServiceClient(MiddlewareReceiptFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @Override
    public ReceiptInfo createReceiptBill(ReceiptBill receiptBill) {
        try{
            return feignClient.createReceiptBill(receiptBill);
        }catch (Exception e){
            logger.error("Error creating bill: ", e);
            return null;
        }
    }

    @Override
    public ReceiptInfo cancelReceipt(String accessKey) {
        try{
            return feignClient.cancelReceipt(accessKey);
        }catch (Exception e){
            logger.error("Error cancelling receipt: ", e);
            return null;
        }
    }

    @Override
    public ReceiptInfo receiptState(String accessKey) {
        try{
            return feignClient.receiptState(accessKey);
        }catch (Exception e){
            logger.error("Error obtain receipt state: ", e);
            return null;
        }
    }

    @Override
    public Receipt findReceiptByAcessKey(String accessKey) {
        try{
            return feignClient.findReceiptByAcessKey(accessKey);
        }catch (Exception e){
            logger.error("Error obtain receipt: ", e);
            return null;
        }
    }
}
