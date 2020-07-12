package com.example.a91773.myapplication2;

import com.google.firebase.database.DatabaseReference;

import java.sql.Struct;

public class Students {
 private    String StPassword;
   private String StEmail;
   private String StPhone;
   private  String StUsername;
private  String StRoll;
Students(){ }

    public Students( String stUsername,String stPassword, String stEmail, String stPhone,String stRoll) {
        this.StPassword = stPassword;
        this.StEmail = stEmail;
        this.StUsername=stUsername;
        this.StPhone = stPhone;
        this.StRoll=stRoll;
    }

    public void setStUsername(String stUsername) {
        StUsername = stUsername;
    }

    public void setStRoll(String stRoll) {
        StRoll = stRoll;
    }

    public String getStRoll() {
        return StRoll;
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