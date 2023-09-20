package ec.gob.registrocivil.share.middleware.receipt.domain.service;

import ec.gob.registrocivil.share.middleware.receipt.domain.Receipt;
import ec.gob.registrocivil.share.middleware.receipt.domain.ReceiptBill;
import ec.gob.registrocivil.share.middleware.receipt.domain.ReceiptInfo;

public interface IMiddlewareReceiptServiceClient {
    ReceiptInfo createReceiptBill( ReceiptBill receiptBill);

    ReceiptInfo cancelReceipt(String accessKey);

    ReceiptInfo receiptState(String accessKey);

    Receipt findReceiptByAcessKey(String accessKey);
}
