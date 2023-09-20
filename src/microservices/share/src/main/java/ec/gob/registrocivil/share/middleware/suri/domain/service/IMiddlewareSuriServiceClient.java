package ec.gob.registrocivil.share.middleware.suri.domain.service;

import ec.gob.registrocivil.share.middleware.suri.domain.DuplicateInfo;

public interface IMiddlewareSuriServiceClient {

    DuplicateInfo validateDuplicate( String nui, Integer documentType);

    DuplicateInfo createDuplicate( String nui, Integer documentType, String receiptNumber, Integer printedAgencyId,  String nuiOperator,
                                   Integer operatorAgencyId, String canal);
    Integer passportNumberByYear( String receiptNumber);

    String firstPasportRenovation(String receiptNumber,  String documentTypeAcronym , String desPassportHistory);

    String  firstIdentitycardRenovation(String receiptNumber);
}
