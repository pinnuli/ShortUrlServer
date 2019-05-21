package com.cvte.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * @author linxiaoyi
 * @date 2019/4/18
 */
public class ServerResponse<T> implements Serializable {

    private static final long serialVersionUID = 4635614821711991447L;

    /**
     * 状态码
     */
    private int code;
    /**
     * 信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    /**
     * 私有构造器
     *
     * @param code 状态码
     * @param message 提示信息
     * @param data 数据
     */
    private ServerResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private ServerResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public static ServerResponse createBySuccess() {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage());
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

    public static <T> ServerResponse<T> createByError(String msg) {
        return new ServerResponse<>(ResponseCode.UNKNOWN_EXCEPTION_ERROR.getCode(), msg);
    }

    public static <T> ServerResponse<T> createByError(Integer code, String msg) {
        return new ServerResponse<>(code, msg);
    }


    @Override
    public String toString() {
        return "ServerResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
