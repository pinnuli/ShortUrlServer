package com.cvte.controller;

import com.cvte.common.ServerResponse;
import com.cvte.po.User;
import com.cvte.service.UserService;
import com.cvte.util.PageUtil;
import com.cvte.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linxiaoyi
 * @date 2019/4/25
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ServerResponse<Map> login(@RequestBody User user) {
        UserVo userVo = userService.login(user);
        Map<String, UserVo> data = new HashMap<>();
        data.put("user", userVo);
        return ServerResponse.createBySuccess(data);
    }

    @PostMapping(value = "/logout")
    public ServerResponse logout(@RequestAttribute User currentUser) {
        userService.logout(currentUser.getUserId());
        return ServerResponse.createBySuccess();
    }

    @PostMapping(value = "/register")
    public ServerResponse register(@RequestBody User user) {
        userService.register(user);
        return ServerResponse.createBySuccess();
    }

    @GetMapping()
    public ServerResponse getAllUser(@RequestParam(required = false) Integer currentPage) {
        PageUtil page = new PageUtil(currentPage);
        Map<String, Object> data = new HashMap<>();
        data.put("userList", userService.getUserList(page));
        data.put("pageInfo", page);
        return ServerResponse.createBySuccess(data);
    }

    @GetMapping("/admin")
    public ServerResponse getAdminList(@RequestParam(required = false) Integer currentPage) {
        PageUtil page = new PageUtil(currentPage);
        Map<String, Object> data = new HashMap<>();
        data.put("adminList", userService.getAdminList(page));
        data.put("pageInfo", page);
        return ServerResponse.createBySuccess(data);
    }

    @PostMapping("/admin")
    public ServerResponse setAdmin(@RequestBody Map<String, Object> requestBody) {
        userService.setAdmin((Integer)requestBody.get("userId"));
        return ServerResponse.createBySuccess();
    }

    @DeleteMapping("/admin")
    public ServerResponse cancelAdmin(@RequestBody Map<String, Object> requestBody) {
        userService.cancelAdmin((Integer)requestBody.get("userId"));
        return ServerResponse.createBySuccess();
    }

    @GetMapping("/black_list")
    public ServerResponse getBlackList(@RequestParam(required = false) Integer currentPage) {
        PageUtil page = new PageUtil(currentPage);
        Map<String, Object> data = new HashMap<>();
        data.put("blackList", userService.getBlackList(page));
        data.put("pageInfo", page);
        return ServerResponse.createBySuccess(data);
    }

    @PostMapping("/black_list")
    public ServerResponse setBlackList(@RequestBody Map<String, Object> requestBody) {
        userService.setBlackList((Integer)requestBody.get("userId"));
        return ServerResponse.createBySuccess();
    }

    @DeleteMapping("/black_list")
    public ServerResponse cancelBlackList(@RequestBody Map<String, Object> requestBody) {
        userService.cancelBlackList((Integer)requestBody.get("userId"));
        return ServerResponse.createBySuccess();
    }
}
