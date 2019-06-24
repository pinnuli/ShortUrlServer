package com.cvte.vo;

import com.cvte.po.UrlReport;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pinnuli
 * @date 2019/6/24
 */
public class CreateReportVo implements Serializable {

    private static final long serialVersionUID = 4187399300475351748L;

    private Date createDate;

    private Integer createCount;

    public CreateReportVo(UrlReport urlReport) {
        this.createDate = urlReport.getDate();
        this.createCount = urlReport.getCount();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateCount() {
        return createCount;
    }

    public void setCreateCount(Integer createCount) {
        this.createCount = createCount;
    }
}
