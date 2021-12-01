package com.yangzhou.intelligent.model;

import java.util.Date;

public class YDUser {
    private String userId;

    private String userAccount;

    private String userNickName;

    private String userPassword;

    private Date userRegisterDate;

    private String userEmail;

    private String userPhone;

    private Integer userSex;

    private String userSchoolName;

    private String userStudentNumber;

    private String userAcademyName;

    private String userIntorduce;

    private String userClassNumber;

    private String userAvatar;

    private Integer isDel;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName == null ? null : userNickName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Date getUserRegisterDate() {
        return userRegisterDate;
    }

    public void setUserRegisterDate(Date userRegisterDate) {
        this.userRegisterDate = userRegisterDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserSchoolName() {
        return userSchoolName;
    }

    public void setUserSchoolName(String userSchoolName) {
        this.userSchoolName = userSchoolName == null ? null : userSchoolName.trim();
    }

    public String getUserStudentNumber() {
        return userStudentNumber;
    }

    public void setUserStudentNumber(String userStudentNumber) {
        this.userStudentNumber = userStudentNumber == null ? null : userStudentNumber.trim();
    }

    public String getUserAcademyName() {
        return userAcademyName;
    }

    public void setUserAcademyName(String userAcademyName) {
        this.userAcademyName = userAcademyName == null ? null : userAcademyName.trim();
    }

    public String getUserIntorduce() {
        return userIntorduce;
    }

    public void setUserIntorduce(String userIntorduce) {
        this.userIntorduce = userIntorduce == null ? null : userIntorduce.trim();
    }

    public String getUserClassNumber() {
        return userClassNumber;
    }

    public void setUserClassNumber(String userClassNumber) {
        this.userClassNumber = userClassNumber == null ? null : userClassNumber.trim();
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}