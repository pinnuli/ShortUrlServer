package com.cvte.exception;

import com.cvte.common.ResponseCode;

/**
 * 全局公共异常
 * @author linxiaoyi
 * @date 2019/5/21
 */
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = -7945004166156241635L;

    private ResponseCode responseCode;

    public CommonException(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getCode() {
        return this.responseCode.getCode();
    }

    @Override
    public String getMessage() {
        return this.responseCode.getMessage();
    }
}
