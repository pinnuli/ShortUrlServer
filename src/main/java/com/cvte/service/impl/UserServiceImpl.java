package com.cvte.service.impl;

import com.cvte.common.ResponseCode;
import com.cvte.dao.UrlMapper;
import com.cvte.dao.UserMapper;
import com.cvte.exception.CommonException;
import com.cvte.po.UrlTotalReport;
import com.cvte.po.User;
import com.cvte.service.TokenService;
import com.cvte.service.UserService;
import com.cvte.util.MD5Util;
import com.cvte.util.PageUtil;
import com.cvte.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author linxiaoyi
 * @date 2019/4/25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UrlMapper urlMapper;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserVo login(User user) {
        User validUser = userMapper.getUserByUserName(user.getUsername());
        checkUserInfo(validUser, user);
        return new UserVo(validUser, tokenService.issueToken(validUser.getUserId()), urlMapper.selectCreateAndVisitCountByUserId(validUser.getUserId()));
    }

    @Override
    public void logout(Integer userId) {
        tokenService.deleteToken(userId);
    }

    @Override
    public void register(User user) {
        checkUsername(user.getUsername());
        user.setPassword(MD5Util.MD5Encode(user.getPassword(), "UTF-8"));
        userMapper.insert(user);
    }

    @Override
    public List<UserVo> getUserList(PageUtil page) {
        List<UserVo> userList = new ArrayList<>();
        page.setTotalNumber(userMapper.selectAllUserCount());
        Map<Integer, UrlTotalReport> urlTotalReportMap = urlMapper.selectCreateAndVisitCountByPage(page);
        for (User user : userMapper.selectAllUser(page)) {
            userList.add(new UserVo(user, urlTotalReportMap.get(user.getUserId())));
        }
        return userList;
    }

    @Override
    public List<UserVo> getBlackList(PageUtil page) {
        List<UserVo> blackList = new ArrayList<>();
        page.setTotalNumber(userMapper.selectBlackUserCount());
        Map<Integer, UrlTotalReport> urlTotalReportMap = urlMapper.selectBlackCreateAndVisitCountByPage(page);
        for (User user : userMapper.selectBlackUser(page)) {
            blackList.add(new UserVo(user, urlTotalReportMap.get(user.getUserId())));
        }
        return blackList;
    }

    @Override
    public List<UserVo> getAdminList(PageUtil page) {
        List<UserVo> adminList = new ArrayList<>();
        page.setTotalNumber(userMapper.selectAdminUserCount());
        Map<Integer, UrlTotalReport> urlTotalReportMap = urlMapper.selectAdminCreateAndVisitCountByPage(page);
        for (User user : userMapper.selectAdminUser(page)) {
            adminList.add(new UserVo(user, urlTotalReportMap.get(user.getUserId())));
        }
        return adminList;
    }

    @Override
    public void setAdmin(Integer userId) {
        userMapper.setAdminByUserId(userId);
    }

    @Override
    public void cancelAdmin(Integer userId) {
        userMapper.cancelAdminByUserId(userId);
    }

    @Override
    public void setBlackList(Integer userId) {
        userMapper.setBlackListByUserId(userId);
    }

    @Override
    public void cancelBlackList(Integer userId) {
        userMapper.cancelBlackListByUserId(userId);
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
        if (!validUser.getPassword().equals(MD5Util.MD5Encode(user.getPassword(), "UTF-8"))) {
            throw new CommonException(ResponseCode.PASSWORD_ERROR);
        }
    }
}
