package com.cvte.dao;

import com.cvte.po.UrlTotalReport;
import com.cvte.util.PageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;


/**
 * @author linxiaoyi
 * @date 2019/5/22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
public class UrlMapperTest {
    private static Logger log = LoggerFactory.getLogger(UrlMapperTest.class);

    @Autowired
    private UrlMapper urlMapper;

    @Autowired
    private UserMapper userMapper;

    private UrlIndexMapper urlIndexMapper;

    @Test
    public void testSelectReportDataByUserIdAndDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        log.info("size:{}", urlMapper.selectCreateReportByUserIdAndDate(3, sdf.parse("2019-06-14 00:00:00"), sdf.parse("2019-06-19 23:00:00")).size());
    }

    @Test
    public void testSelectCreateAndVisitCountByPage() {
        PageUtil pageUtil = new PageUtil(1);
        pageUtil.setTotalNumber(userMapper.selectAllUserCount());
        Map<Integer, UrlTotalReport> result = urlMapper.selectCreateAndVisitCountByPage(pageUtil);
        System.out.println("size: " + result.size());
        System.out.println(result);
        System.out.println(result.get(1));
    }
}
