package com.cvte.service;

import com.cvte.po.User;
import com.cvte.vo.UserVo;

/**
 * @author linxiaoyi
 * @date 2019/4/25
 */
public interface UserService {

    /**
     * @param user 用户信息
     * @return token
     */
    String login(User user);

    /**
     * @param userId 用户id
     */
    void logout(Integer userId);

    /**
     * @param userId 用户id
     * @return 用户信息
     */
    UserVo getUserInfo(Integer userId);

    void register(User user);
}
