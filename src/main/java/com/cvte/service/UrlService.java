package com.cvte.service;

import com.cvte.vo.CreateReportVo;
import com.cvte.vo.VisitReportVo;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author linxiaoyi
 * @date 2019/5/21
 */
public interface UrlService {

    /**
     * @param userId 用户id
     * @param longUrl 长链接
     * @return 生成的短链接
     */
    String getShortUrl(Integer userId, String longUrl) throws IOException;

    /**
     * @param shortUrl 短链接
     * @return 对应长链接
     */
    String visitShortUrl(String shortUrl);

    /**
     * 增加短链访问次数
     * @param shortUrl 短链
     */
    void increaseVisitCount(String shortUrl);

    /**
     * @param userId 用户id
     * @param startDate 起始日期
     * @param endDate 结束日期
     * @return 数据列表
     */
    List<CreateReportVo> getCreateReportData(Integer userId, Date startDate, Date endDate);

    /**
     * @param userId 用户id
     * @param startDate 起始日期
     * @param endDate 结束日期
     * @return 数据列表
     */
    List<VisitReportVo> getVisitReportData(Integer userId, Date startDate, Date endDate);
}
