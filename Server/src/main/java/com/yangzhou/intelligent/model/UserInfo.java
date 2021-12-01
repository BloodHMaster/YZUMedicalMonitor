package com.yangzhou.intelligent.model;

public class UserInfo {
    private String user_avatar;
    private String user_nick_name;

    public void setuser_avatar(String user_avatar) {
        this.user_avatar = user_avatar == null ? null : user_avatar.trim();
    }

    public String getuser_avatar() {
        return user_avatar;
    }
    public void setuser_nick_name(String user_nick_name) {
        this.user_nick_name = user_nick_name == null ? null : user_nick_name.trim();
    }
    public String getuser_nick_name() {
        return user_nick_name;
    }
}
