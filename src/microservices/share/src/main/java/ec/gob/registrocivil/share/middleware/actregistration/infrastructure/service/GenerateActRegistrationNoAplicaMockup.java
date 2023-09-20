package ec.gob.registrocivil.share.middleware.actregistration.infrastructure.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;

public class GenerateActRegistrationNoAplicaMockup {
    
    public static byte[] generarPdfBase64() {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, baos);
            document.open();
            document.add(new Paragraph("Usuario no aplica al sistema."));
            document.close();
        } catch (Exception e) {
            throw new RuntimeException("No es posible acceder al servicio solicitado.");
        }
        return baos.toByteArray();
    }
}
