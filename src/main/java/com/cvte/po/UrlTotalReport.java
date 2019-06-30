package com.cvte.po;

/**
 * @author pinnuli
 * @date 2019/6/29
 */
public class UrlTotalReport {

    private Integer userId;

    private Integer createShortUrlCount;

    private Integer visitShortUrlCount;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
