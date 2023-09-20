package ec.gob.registrocivil.share.middleware.certificationsimple.domain;

public class SimpleCertification {
    private byte [] document;
    private boolean error;
    private String msg;

    public SimpleCertification(byte[] document, boolean error, String msg) {
        this.document = document;
        this.error = error;
        this.msg = msg;
    }

    public SimpleCertification() {
    }

    public byte[] getDocument() {
        return document;
    }

    public boolean isError() {
        return error;
    }

    public String getMsg() {
        return msg;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
