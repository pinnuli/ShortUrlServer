package com.cvte.po;

import java.io.Serializable;

/**
 * @author linxioayi
 * @date 2019/05/21
 */
public class User implements Serializable {
    private static final long serialVersionUID = 436497683640969125L;

    private Integer userId;

    private String username;

    public User(){}

    public User(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

}