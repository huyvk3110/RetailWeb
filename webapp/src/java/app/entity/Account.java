/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author huy
 */
public class Account {

    String accountId;
    String userName;
    String passWord;
    int type;
    String fullName;
    Date birthDay;
    String mail;
    String phone;
    String address;
    Date created;
    int point;
    boolean status = true;
    String avatar;
    boolean isOnline;

    public Account() {
    }

    public Account(String accountId, String userName, String passWord, int type, String fullName, Date birthDay, String mail, String phone, String address, Date created, int point, boolean status, String avatar, boolean isOnline) {
        this.accountId = accountId;
        this.userName = userName;
        this.passWord = passWord;
        this.type = type;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
        this.created = created;
        this.point = point;
        this.status = status;
        this.avatar = avatar;
        this.isOnline = isOnline;
    }

    public boolean isIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
