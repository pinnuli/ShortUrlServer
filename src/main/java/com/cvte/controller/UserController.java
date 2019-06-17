package com.cvte.controller;

import com.cvte.common.ServerResponse;
import com.cvte.po.User;
import com.cvte.service.UserService;
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
        String token = userService.login(user);
        Map<String, String> data = new HashMap<>();
        data.put("token", token);
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
}
