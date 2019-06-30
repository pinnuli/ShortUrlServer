package com.cvte.po;

import java.io.Serializable;
import java.util.Date;

/**
 * author@ pinnuli
 * date@ 2019/6/24
 */
public class UrlDateReport implements Serializable{
    private static final long serialVersionUID = 1987149075639889482L;

    private Date date;

    private Integer count;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
