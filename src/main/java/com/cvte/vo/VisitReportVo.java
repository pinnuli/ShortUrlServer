package com.cvte.vo;

import com.cvte.po.UrlReport;

import java.io.Serializable;
import java.util.Date;

/**
 * author@ pinnuli
 * date@ 2019/6/24
 */
public class VisitReportVo implements Serializable{

    private static final long serialVersionUID = 3542392543894053992L;

    private Date date;

    private Integer visitCount;

    public VisitReportVo(UrlReport urlReport) {
        this.date = urlReport.getDate();
        this.visitCount = urlReport.getCount();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }
}
