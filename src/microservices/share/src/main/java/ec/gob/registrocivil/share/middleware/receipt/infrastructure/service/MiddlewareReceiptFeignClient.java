package ec.gob.registrocivil.share.middleware.receipt.infrastructure.service;


import ec.gob.registrocivil.share.middleware.receipt.domain.Receipt;
import ec.gob.registrocivil.share.middleware.receipt.domain.ReceiptBill;
import ec.gob.registrocivil.share.middleware.receipt.domain.ReceiptInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "middleware", path = "/api/comprobantes" , contextId = "comprobantes")
public interface MiddlewareReceiptFeignClient {

    @PostMapping(path = "/crear/factura")
    ReceiptInfo createReceiptBill(@RequestBody ReceiptBill receiptBill);

    @GetMapping(path = "/anular/comprobante")
    ReceiptInfo cancelReceipt(@RequestParam(name = "claveAcceso" , required = true) String accessKey);

    @GetMapping(path = "/anular/comprobante")
    ReceiptInfo receiptState(@RequestParam(name = "claveAcceso", required = true) String accessKey);

    @GetMapping(path = "/comprobante")
    Receipt findReceiptByAcessKey(@RequestParam(name = "claveAcceso", required = true) String accessKey);
}
