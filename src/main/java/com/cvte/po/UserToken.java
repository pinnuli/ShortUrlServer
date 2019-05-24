package com.cvte.po;

import com.cvte.common.StaticConfig;
import com.cvte.util.DateTimeUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linxiaoyi
 * @date 2019/05/21
 */
public class UserToken implements Serializable {

    private static final long serialVersionUID = -4215100843411907096L;

    private Integer userId;

    private String token;

    private Date expireTime;

    public UserToken() {}

    public UserToken(Integer userId, String token) {
        this.userId = userId;
        this.token = token;
        this.expireTime = DateTimeUtil.getDateTimeAfterSeconds(StaticConfig.TOKEN_LIFECYCLE);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}
