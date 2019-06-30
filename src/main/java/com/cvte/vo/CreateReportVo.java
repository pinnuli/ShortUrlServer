package com.cvte.vo;

import com.cvte.po.UrlDateReport;
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

    public CreateReportVo(UrlDateReport urlDateReport) {
        this.createDate = DateTimeUtil.getDate(urlDateReport.getDate());
        this.createCount = urlDateReport.getCount();
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
