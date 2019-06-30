package com.cvte.controller;

import com.cvte.common.ServerResponse;
import com.cvte.po.User;
import com.cvte.service.UrlService;
import com.cvte.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linxiaoyi
 * @date 2019/5/22
 */
@RequestMapping("/short_url")
@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/creation")
    public ServerResponse getShortUrl(@RequestAttribute User currentUser, @RequestBody Map<String, String> parameter) throws IOException {
        String longUrl = parameter.get("longUrl");
        String shortUrl = urlService.getShortUrl(currentUser.getUserId(), longUrl);
        Map<String, String> data = new HashMap<>();
        data.put("shortUrl", shortUrl);
        return ServerResponse.createBySuccess(data);
    }

    @GetMapping("/visit")
    public ServerResponse getLongUrl(@RequestParam String shortUrl) {
        String longUrl = urlService.visitShortUrl(shortUrl);
        Map<String, String> data = new HashMap<>();
        data.put("longUrl", longUrl);
        return ServerResponse.createBySuccess(data);
    }

    @GetMapping("/report/creation")
    public ServerResponse getCreateReport(@RequestAttribute User currentUser,
                                          @RequestParam(required = false) Integer userId,
                                          @RequestParam String startDate,
                                          @RequestParam String endDate) {
        Date startDateTime = DateTimeUtil.getDateTimeFromString(startDate);
        Date endDateTime = DateTimeUtil.getNextZeroTimeFromString(endDate);
        userId = userId == null ? currentUser.getUserId() : userId;
        Map<String, Object> data = new HashMap<>();
        data.put("createReportList", urlService.getCreateReportData(userId, startDateTime, endDateTime));
        return ServerResponse.createBySuccess(data);
    }

    @GetMapping("/report/visit")
    public ServerResponse getVisitReport(@RequestAttribute User currentUser,
                                         @RequestParam(required = false) Integer userId,
                                         @RequestParam String startDate,
                                         @RequestParam String endDate) {
        Date startDateTime = DateTimeUtil.getDateTimeFromString(startDate);
        Date endDateTime = DateTimeUtil.getNextZeroTimeFromString(endDate);
        userId = userId == null ? currentUser.getUserId() : userId;
        Map<String, Object> data = new HashMap<>();
        data.put("visitReportList", urlService.getVisitReportData(userId, startDateTime, endDateTime));
        return ServerResponse.createBySuccess(data);
    }

}
