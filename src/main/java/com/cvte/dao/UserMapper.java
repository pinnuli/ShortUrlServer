package com.cvte.dao;

import com.cvte.po.User;

/**
 * @author linxioayi
 * @date 2019/04/19
 */
public interface UserMapper {

    User getUserById(Integer userId);

    User getUserByUserName(String username);

    Integer getUserIdByUsername(String username);

    void insert(User user);
}