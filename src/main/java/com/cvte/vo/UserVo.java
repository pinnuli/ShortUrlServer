package com.cvte.vo;

import com.cvte.po.UrlTotalReport;
import com.cvte.po.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author linxiaoyi
 * @date 2019/4/25
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVo implements Serializable {

    private static final long serialVersionUID = 7660796948714065243L;

    private Integer userId;

    private String username;

    private Boolean isBlack;

    private Boolean isAdmin;

    private Integer createShortUrlCount;

    private Integer visitShortUrlCount;

    private String token;

    public UserVo(User user, UrlTotalReport urlTotalReport){
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.isBlack = user.getIsBlack();
        this.isAdmin = user.getIsAdmin();
        this.createShortUrlCount = urlTotalReport == null ? 0 : urlTotalReport.getCreateShortUrlCount();
        this.visitShortUrlCount = urlTotalReport == null ? 0 :urlTotalReport.getVisitShortUrlCount();
    }

    public UserVo(User user, String token, UrlTotalReport urlTotalReport) {
        this.username = user.getUsername();
        this.isBlack = user.getIsBlack();
        this.isAdmin = user.getIsAdmin();
        this.createShortUrlCount = urlTotalReport.getCreateShortUrlCount() == null ? 0 : urlTotalReport.getCreateShortUrlCount();
        this.visitShortUrlCount = urlTotalReport.getVisitShortUrlCount() == null ? 0 : urlTotalReport.getVisitShortUrlCount();
        this.token = token;
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

    public Boolean getBlack() {
        return isBlack;
    }

    public void setBlack(Boolean black) {
        isBlack = black;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Integer getCreateShortUrlCount() {
        return createShortUrlCount;
    }

    public void setCreateShortUrlCount(Integer createShortUrlCount) {
        this.createShortUrlCount = createShortUrlCount;
    }

    public Integer getVisitShortUrlCount() {
        return visitShortUrlCount;
    }

    public void setVisitShortUrlCount(Integer visitShortUrlCount) {
        this.visitShortUrlCount = visitShortUrlCount;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
