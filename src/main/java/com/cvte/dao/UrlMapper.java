package com.cvte.dao;

import com.cvte.po.Url;
import com.cvte.po.UrlDateReport;
import com.cvte.po.UrlTotalReport;
import com.cvte.util.PageUtil;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author linxiaoyi
 * @date 2019/5/21
 */
public interface UrlMapper {

    void insert (Url url) throws DataAccessException;

    String selectLongUrlByShortUrl(String shortUrl);

    void increaseVisitCount(String shortUrl);

    List<UrlDateReport> selectCreateReportByUserIdAndDate(@Param("userId") Integer userId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<UrlDateReport> selectVisitReportByUserIdAndDate(@Param("userId") Integer userId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    UrlTotalReport selectCreateAndVisitCountByUserId(Integer userId);

    @MapKey("userId")
    Map<Integer, UrlTotalReport> selectCreateAndVisitCountByPage(PageUtil page);

    @MapKey("userId")
    Map<Integer, UrlTotalReport> selectBlackCreateAndVisitCountByPage(PageUtil page);

    @MapKey("userId")
    Map<Integer, UrlTotalReport> selectAdminCreateAndVisitCountByPage(PageUtil page);
}
