package com.yaoyao.domain;

import java.util.Date;

/**
 * Created by HOME on 2017-07-05.
 */
public class LoginLog {//implements Serializable

    private int loginId;

    private int userId;

    private String ip;

    private Date loginDate;

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
