package com.cvte.controller;

import com.cvte.common.ServerResponse;
import com.cvte.po.User;
import com.cvte.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linxiaoyi
 * @date 2019/5/22
 */
@RestController
public class UrlController {

    @Autowired
    private ShortUrlService shortUrlService;

    @PostMapping("/url/short_url")
    public ServerResponse getShortUrl(@RequestAttribute User currentUser, @RequestParam String longUrl, HttpServletRequest request) {
        String shortUrl = shortUrlService.generateShortUrl(currentUser.getUserId(), longUrl);
        Map<String, String> data = new HashMap<>();
        data.put("shortUrl", getAbsoluteUrl(request, shortUrl));
        return ServerResponse.createBySuccess(data);
    }

    @GetMapping("/{shortUrl}")
    public void redirectToLongUrl(HttpServletRequest request, HttpServletResponse response, @PathVariable String shortUrl) throws IOException {
        String longUrl = shortUrlService.visitShortUrl(shortUrl);
        if (longUrl == null) {
            longUrl = getAbsoluteUrl(request, "not_found_error.jsp");
        }
        response.setStatus(301);
        response.sendRedirect(longUrl);
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
