package com.example.a91773.myapplication2;

public class Parents {
    private    String StPassword;
    private String StEmail;
    private String StPhone;
    private  String StUsername;
    private  String StRoll;
    private  String StUn;

    Parents(){}

    public Parents(String stPassword, String stEmail, String stPhone, String stUsername, String stUn,String stRoll) {
        StPassword = stPassword;
        StEmail = stEmail;
        StPhone = stPhone;
        StUsername = stUsername;
        StRoll = stRoll;
        StUn=stUn;
    }

    public String getStUn() {
        return StUn;
    }

    public void setStUn(String stUn) {
        StUn = stUn;
    }

    public String getStPassword() {
        return StPassword;
    }

    public String getStEmail() {
        return StEmail;
    }

    public String getStPhone() {
        return StPhone;
    }

    public void setStEmail(String stEmail) {
        StEmail = stEmail;
    }

    public void setStPhone(String stPhone) {
        StPhone = stPhone;
    }

    public void setStUsername(String stUsername) {
        StUsername = stUsername;
    }

    public void setStRoll(String stRoll) {
        StRoll = stRoll;
    }

    public String getStUsername() {
        return StUsername;
    }

    public String getStRoll() {
        return StRoll;
    }

    public void setStPassword(String stPassword) {
        StPassword = stPassword;
    }
}
