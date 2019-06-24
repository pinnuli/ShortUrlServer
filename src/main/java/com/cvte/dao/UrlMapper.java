package com.cvte.dao;

import com.cvte.po.Url;
import com.cvte.po.UrlReport;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.Date;
import java.util.List;


/**
 * @author linxiaoyi
 * @date 2019/5/21
 */
public interface UrlMapper {

    void insert (Url url) throws DataAccessException;

    String selectLongUrlByShortUrl(String shortUrl);

    void increaseVisitCount(String shortUrl);

    List<UrlReport> selectCreateReportByUserIdAndDate(@Param("userId") Integer userId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<UrlReport> selectVisitReportByUserIdAndDate(@Param("userId") Integer userId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
