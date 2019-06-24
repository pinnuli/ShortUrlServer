package com.cvte.interceptor;

import com.cvte.common.ResponseCode;
import com.cvte.exception.CommonException;
import com.cvte.po.User;
import com.cvte.service.TokenService;
import com.cvte.service.impl.TokenServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author linxiaoyi
 * @date 2019/4/29
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private  static Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private TokenService tokenServiceImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("Token");
        if (token == null) {
            throw new CommonException(ResponseCode.TOKEN_NOT_FOUND);
        }

        if (!tokenServiceImpl.checkToken(token)) {
            throw new CommonException(ResponseCode.INVALID_TOKEN_ERROR);
        }
        User user = tokenServiceImpl.updateToken(token);
        request.setAttribute("currentUser", user);
        return true;
    }
}
