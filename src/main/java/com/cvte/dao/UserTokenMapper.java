package com.cvte.dao;

import com.cvte.po.UserToken;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author linxiaoyi
 * @date 2019/5/21
 */
public interface UserTokenMapper {

    UserToken selectByToken(String token);

    void insertOrUpdate(UserToken userToken);

    void updateExpireTimeByUserId(@Param("userId") Integer userId, @Param("expireTime") Date expireTime);
}
