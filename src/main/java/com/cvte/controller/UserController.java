package com.cvte.controller;

import com.cvte.common.ServerResponse;
import com.cvte.po.User;
import com.cvte.service.UserService;
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
    public ServerResponse<Map> login(@RequestParam Integer userId) {
        String token = userService.login(userId);
        Map<String, String> data = new HashMap<>();
        data.put("token", token);
        return ServerResponse.createBySuccess(data);
    }

    @GetMapping
    public ServerResponse<UserVo> getTaskList(@RequestAttribute User currentUser){
        return ServerResponse.createBySuccess(userService.getUserInfo(currentUser.getUserId()));
    }

    @PostMapping(value = "/logout")
    public ServerResponse logout(@RequestAttribute User currentUser) {
        userService.logout(currentUser.getUserId());
        return ServerResponse.createBySuccess();
    }
}
