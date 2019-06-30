package com.cvte.dao;

import com.cvte.po.User;
import com.cvte.util.PageUtil;

import java.util.List;

/**
 * @author linxioayi
 * @date 2019/04/19
 */
public interface UserMapper {

    User getUserById(Integer userId);

    User getUserByUserName(String username);

    Integer getUserIdByUsername(String username);

    List<User> selectAllUser(PageUtil page);

    Integer selectAllUserCount();

    List<User> selectBlackUser(PageUtil page);

    Integer selectBlackUserCount();

    List<User> selectAdminUser(PageUtil page);

    Integer selectAdminUserCount();

    void insert(User user);

    void setAdminByUserId(Integer userId);

    void cancelAdminByUserId(Integer userId);

    void setBlackListByUserId(Integer userId);

    void cancelBlackListByUserId(Integer userId);
}