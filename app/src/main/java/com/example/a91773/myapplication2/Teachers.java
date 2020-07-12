package com.example.a91773.myapplication2;

public class Teachers {
    private    String StPassword;
    private String StEmail;
    private String StPhone;
    private  String StUsername;

    Teachers(){ }

    public Teachers( String stUsername,String stPassword, String stEmail, String stPhone) {
        this.StPassword = stPassword;
        this.StEmail = stEmail;
        this.StUsername=stUsername;
        this.StPhone = stPhone;
    }

    public void setStUsername(String stUsername) {
        StUsername = stUsername;
    }

    public String getStUsername() {
        return StUsername;
    }

    public void setStPassword(String stPassword) {
        this.StPassword = stPassword;
    }

    public void setStEmail(String stEmail) {
        this.StEmail = stEmail;
    }

    public void setStPhone(String stPhone) {
        this.StPhone = stPhone;
    }

    public String getStPassword() {
        return this.StPassword;
    }

    public String getStEmail() {
        return this.StEmail;
    }

    public String getStPhone() {
        return this.StPhone;
    }



}
