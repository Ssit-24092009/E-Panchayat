package example.com.e_panchayat.Models;

public class GrivenceModel {

    String address,category,date,fullname,grivence,time,ward;

    public GrivenceModel() {
    }

    public GrivenceModel(String address, String category, String date, String fullname, String grivence, String time, String ward) {
        this.address = address;
        this.category = category;
        this.date = date;
        this.fullname = fullname;
        this.grivence = grivence;
        this.time = time;
        this.ward = ward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGrivence() {
        return grivence;
    }

    public void setGrivence(String grivence) {
        this.grivence = grivence;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }
}
