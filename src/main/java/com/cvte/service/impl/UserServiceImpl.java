package com.cvte.service.impl;

import com.cvte.dao.UserMapper;
import com.cvte.po.User;
import com.cvte.service.TokenService;
import com.cvte.service.UserService;
import com.cvte.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linxiaoyi
 * @date 2019/4/25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenService tokenService;

    @Override
    public String login(Integer userId) {
        return tokenService.issueToken(userId);
    }

    @Override
    public void logout(Integer userId) {
        tokenService.deleteToken(userId);
    }

    @Override
    public UserVo getUserInfo(Integer userId) {
        User user = userMapper.getUserById(userId);
        return new UserVo(user);
    }
}
