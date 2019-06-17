package com.cvte.controller;

import com.cvte.common.ServerResponse;
import com.cvte.po.User;
import com.cvte.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linxiaoyi
 * @date 2019/5/22
 */
@RequestMapping("/url")
@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping(value = "/short_url")
    public ServerResponse getShortUrl(@RequestAttribute User currentUser, @RequestParam String longUrl, HttpServletRequest request) throws IOException {
        String shortUrl = urlService.getShortUrl(currentUser.getUserId(), longUrl);
        Map<String, String> data = new HashMap<>();
        data.put("shortUrl", getAbsoluteUrl(request, shortUrl));
        return ServerResponse.createBySuccess(data);
    }

    @GetMapping(value= "/long_url")
    public ServerResponse redirectToLongUrl(@RequestParam String shortUrl) {
        String longUrl = urlService.visitShortUrl(shortUrl);
        Map<String, String> data = new HashMap<>();
        data.put("longUrl", longUrl);
        return ServerResponse.createBySuccess(data);
    }

    private String getAbsoluteUrl(HttpServletRequest request, String subPath) {
        StringBuffer url = request.getRequestURL();
        return url.delete(url.length() - request.getRequestURI().length(), url.length())
                .append(request.getServletContext().getContextPath())
                .append("/")
                .append(subPath)
                .toString();
    }


}
