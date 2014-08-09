package com.example.model;

/**
 * Created with IntelliJ IDEA.
 * User: ehc
 * Date: 9/8/14
 * Time: 12:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    public String userName;
    public String emailId;
    public String password;
    public String mobile;
    public String otp;
    public String location;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
