package com.cvte.controller;

import com.cvte.common.ServerResponse;
import com.cvte.exception.CommonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linxiaoyi
 * @date 2019/5/21
 */
/*@ControllerAdvice
@RestController*/
public class WebExceptionHandle {
    private static final Logger log = LoggerFactory.getLogger(WebExceptionHandle.class);

    /**
     * 操作异常
     * @param e 异常
     * @return
     */
    @ExceptionHandler(CommonException.class)
    public ServerResponse handleException(CommonException e) {
        log.info(e.getMessage());
        return ServerResponse.createByError(e.getCode(), e.getMessage());
    }

    /**
     * 系统未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ServerResponse handleException(Exception e) {
        log.error("服务器发生未知异常，异常信息如下：{}", e);
        e.printStackTrace();
        return ServerResponse.createByError("服务器异常");
    }

}
