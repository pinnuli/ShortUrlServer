package com.cvte.common;

/**
 * @author linxiaoyi
 * @date 2019/4/18
 */
public enum ResponseCode {

    /**
     * 请求成功
     */
    SUCCESS(200, "success"),

    /**
     * token无效
     */
    INVALID_TOKEN_ERROR(401, "invalid token, please login again!"),

    /**
     * 未携带token
     */
    TOKEN_NOT_FOUND(401, "token not found, please login"),


    /**
     * 不允许的操作
     */
    FORBIDDEN_OPERATION(403, "forbidden operation"),

    /**
     * 服务端未知异常
     */
    UNKNOWN_EXCEPTION_ERROR(500, "unknown exception");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 状态信息
     */
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

