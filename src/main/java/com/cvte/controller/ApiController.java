package com.cvte.controller;

import com.cvte.common.ServerResponse;
import com.cvte.po.User;
import com.cvte.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pinnuli
 * @date 2019/6/25
 */
@RequestMapping("/api")
@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping
    public ServerResponse getAllApi(@RequestAttribute User currentUser) {
        Map<String, Object> data = new HashMap<>();
        data.put("apiList", apiService.getAllApi());
        return ServerResponse.createBySuccess(data);
    }
}
