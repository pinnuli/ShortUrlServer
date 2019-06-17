package com.cvte.service.impl;

import com.cvte.common.ResponseCode;
import com.cvte.dao.UserMapper;
import com.cvte.exception.CommonException;
import com.cvte.po.User;
import com.cvte.service.TokenService;
import com.cvte.service.UserService;
import com.cvte.util.MD5Util;
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
    public String login(User user) {
        User validUser = userMapper.getUserByUserName(user.getUsername());
        checkUserInfo(validUser, user);
        return tokenService.issueToken(validUser.getUserId());
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

    @Override
    public void register(User user) {
        checkUsername(user.getUsername());
        user.setPassword(MD5Util.MD5Encode(user.getPassword(), "UTF-8"));
        userMapper.insert(user);
    }

    private void checkUsername(String username) {
        if (userMapper.getUserIdByUsername(username) != null) {
            throw new CommonException(ResponseCode.INVALID_USERNAME);
        }
    }

    private void checkUserInfo(User validUser, User user) {
        if (validUser == null) {
            throw new CommonException(ResponseCode.USERNAME_NOT_EXIST);
        }
        System.out.println("pass:" + MD5Util.MD5Encode(user.getPassword(), "UTF-8"));
        if (!validUser.getPassword().equals(MD5Util.MD5Encode(user.getPassword(), "UTF-8"))) {
            throw new CommonException(ResponseCode.PASSWORD_ERROR);
        }
    }
}
