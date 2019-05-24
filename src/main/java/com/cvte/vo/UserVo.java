package com.cvte.vo;

import com.cvte.po.User;

import java.io.Serializable;

/**
 * @author linxiaoyi
 * @date 2019/4/25
 */
public class UserVo implements Serializable {

    private static final long serialVersionUID = 7660796948714065243L;

    private Integer userId;

    private String username;


    public UserVo(){}

    public UserVo(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
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
        this.username = username;
    }
}
