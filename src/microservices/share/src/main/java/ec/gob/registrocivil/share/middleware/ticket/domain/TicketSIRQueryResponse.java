package ec.gob.registrocivil.share.middleware.ticket.domain;

public class TicketSIRQueryResponse {

    private String codeResult;
    private String messageResult;
    private TicketPortalDTO ticketSIR;

    /**
     * Obtiene el valor de la propiedad codeResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeResult() {
        return codeResult;
    }

    /**
     * Define el valor de la propiedad codeResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeResult(String value) {
        this.codeResult = value;
    }

    /**
     * Obtiene el valor de la propiedad messageResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageResult() {
        return messageResult;
    }

    /**
     * Define el valor de la propiedad messageResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageResult(String value) {
        this.messageResult = value;
    }

    /**
     * Obtiene el valor de la propiedad ticketSIR.
     * 
     * @return
     *     possible object is
     *     {@link TicketPortalDTO }
     *     
     */
    public TicketPortalDTO getTicketSIR() {
        return ticketSIR;
    }

    /**
     * Define el valor de la propiedad ticketSIR.
     * 
     * @param value
     *     allowed object is
     *     {@link TicketPortalDTO }
     *     
     */
    public void setTicketSIR(TicketPortalDTO value) {
        this.ticketSIR = value;
    }

}
