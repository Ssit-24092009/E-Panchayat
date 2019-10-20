package example.com.e_panchayat.Models;

public class CertificateModel {

    String certificate_name,certificate_url,commitee,issued_by;

    public CertificateModel() {
    }

    public CertificateModel(String certificate_name, String certificate_url, String commitee, String issued_by) {
        this.certificate_name = certificate_name;
        this.certificate_url = certificate_url;
        this.commitee = commitee;
        this.issued_by = issued_by;
    }

    public String getCertificate_name() {
        return certificate_name;
    }

    public void setCertificate_name(String certificate_name) {
        this.certificate_name = certificate_name;
    }

    public String getCertificate_url() {
        return certificate_url;
    }

    public void setCertificate_url(String certificate_url) {
        this.certificate_url = certificate_url;
    }

    public String getCommitee() {
        return commitee;
    }

    public void setCommitee(String commitee) {
        this.commitee = commitee;
    }

    public String getIssued_by() {
        return issued_by;
    }

    public void setIssued_by(String issued_by) {
        this.issued_by = issued_by;
    }
}
