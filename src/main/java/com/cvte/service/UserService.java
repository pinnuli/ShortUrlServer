package com.cvte.service;

import com.cvte.po.User;
import com.cvte.util.PageUtil;
import com.cvte.vo.UserVo;

import java.util.List;

/**
 * @author linxiaoyi
 * @date 2019/4/25
 */
public interface UserService {

    /**
     * @param user 用户信息
     * @return token
     */
    UserVo login(User user);

    /**
     * @param userId 用户id
     */
    void logout(Integer userId);

    void register(User user);

    List<UserVo> getUserList(PageUtil page);

    List<UserVo> getBlackList(PageUtil page);

    List<UserVo> getAdminList(PageUtil page);

    void setAdmin(Integer userId);

    void cancelAdmin(Integer userId);

    void setBlackList(Integer userId);

    void cancelBlackList(Integer userId);
}
