package com.cvte.service;

import com.cvte.vo.UserVo;

/**
 * @author linxiaoyi
 * @date 2019/4/25
 */
public interface UserService {

    /**
     * @param userId 用户id
     * @return token
     */
    String login(Integer userId);

    /**
     * @param userId 用户id
     */
    void logout(Integer userId);

    /**
     * @param userId 用户id
     * @return 用户信息
     */
    UserVo getUserInfo(Integer userId);
}
