package com.cvte.dao;

import com.cvte.po.Url;
import org.springframework.dao.DataAccessException;


/**
 * @author linxiaoyi
 * @date 2019/5/21
 */
public interface UrlMapper {

    void insert (Url url) throws DataAccessException;

    String selectLongUrlByShortUrl(String shortUrl);
}
