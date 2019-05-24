package com.cvte.interceptor;

import com.cvte.common.ResponseCode;
import com.cvte.exception.CommonException;
import com.cvte.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author linxiaoyi
 * @date 2019/5/23
 */
public class BlackListInterceptor implements HandlerInterceptor {

    private  static Logger log = LoggerFactory.getLogger(BlackListInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        User user = (User)request.getAttribute("currentUser");
        if (user.getIsBlack()) {
            throw new CommonException(ResponseCode.FORBIDDEN_OPERATION);
        }
        return true;
    }
}
