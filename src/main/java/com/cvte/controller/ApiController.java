package com.cvte.controller;

import com.cvte.common.ServerResponse;
import com.cvte.po.Api;
import com.cvte.po.User;
import com.cvte.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/detail")
    public ServerResponse getDetailApiList() {
        Map<String, Object> data = new HashMap<>();
        data.put("apiDetailList", apiService.getDetailApiList());
        return ServerResponse.createBySuccess(data);
    }

    @GetMapping("/detail/{apiId}")
    public ServerResponse getDetailApi(@PathVariable Integer apiId) {
        Map<String, Object> data = new HashMap<>();
        data.put("apiDetail", apiService.getDetailApi(apiId));
        return ServerResponse.createBySuccess(data);
    }

    @GetMapping("/outline")
    public ServerResponse getOutlineApiList(@RequestAttribute User currentUser) {
        Map<String, Object> data = new HashMap<>();
        data.put("apiOutlineList", apiService.getOutlineApiList());
        return ServerResponse.createBySuccess(data);
    }

    @PostMapping
    public ServerResponse addApi(@RequestBody Api api) {
        apiService.addApi(api);
        return ServerResponse.createBySuccess();
    }

    @PutMapping
    public ServerResponse updateApi(@RequestBody Api api) {
        apiService.updateApi(api);
        return ServerResponse.createBySuccess();
    }

    @DeleteMapping
    public ServerResponse deleteApi(@RequestBody Map<String, Object> requestBody) {
        apiService.deleteApi((Integer)requestBody.get("apiId"));
        return ServerResponse.createBySuccess();
    }
}
