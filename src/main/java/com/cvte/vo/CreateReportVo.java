package com.cvte.vo;

import com.cvte.po.UrlReport;
import com.cvte.util.DateTimeUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pinnuli
 * @date 2019/6/24
 */
public class CreateReportVo implements Serializable {

    private static final long serialVersionUID = 4187399300475351748L;

    private String createDate;

    private Integer createCount;

    public CreateReportVo(UrlReport urlReport) {
        this.createDate = DateTimeUtil.getDate(urlReport.getDate());
        this.createCount = urlReport.getCount();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = DateTimeUtil.getDate(createDate);
    }

    public Integer getCreateCount() {
        return createCount;
    }

    public void setCreateCount(Integer createCount) {
        this.createCount = createCount;
    }
}
