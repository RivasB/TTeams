package ec.gob.registrocivil.share.middleware.suri.infrastructure.service;

import ec.gob.registrocivil.share.middleware.suri.domain.DuplicateInfo;
import ec.gob.registrocivil.share.middleware.suri.domain.service.IMiddlewareSuriServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MiddlewareSuriServiceClient implements IMiddlewareSuriServiceClient {

    private final MiddlewareSuriFeignClient client;
    private static final Logger logger = LoggerFactory.getLogger(MiddlewareSuriServiceClient.class);

    public MiddlewareSuriServiceClient(MiddlewareSuriFeignClient client) {
        this.client = client;
    }

    @Override
    public DuplicateInfo validateDuplicate(String nui, Integer documentType) {
        try{
            return client.validateDuplicate(nui, documentType);
        }catch (Exception e){
            logger.error("Error validating duplicate: ", e);
            return null;
        }
    }

    @Override
    public DuplicateInfo createDuplicate(String nui, Integer documentType, String receiptNumber, Integer printedAgencyId,
                                         String nuiOperator, Integer operatorAgencyId, String canal) {
        try{
            return client.createDuplicate(nui, documentType, receiptNumber, printedAgencyId, nuiOperator, operatorAgencyId, canal);
        }catch (Exception e){
            logger.error("Error creating duplicate: ", e);
            return null;
        }
    }

    @Override
    public Integer passportNumberByYear(String receiptNumber) {
        try{
            return client.passportNumberByYear(receiptNumber);
        }catch (Exception e){
            logger.error("Error passport number by year : ", e);
            return null;
        }
    }

    @Override
    public String firstPasportRenovation(String receiptNumber, String documentTypeAcronym, String desPassportHistory) {
        try{
            return client.firstPasportRenovation(receiptNumber, documentTypeAcronym, desPassportHistory);
        }catch (Exception e){
            logger.error("Error first passport renovation: ", e);
            return null;
        }
    }

    @Override
    public String firstIdentitycardRenovation(String receiptNumber) {
        try{
            return client.firstIdentitycardRenovation(receiptNumber);
        }catch (Exception e){
            logger.error("Error first identity card renovation : ", e);
            return null;
        }
    }
}
