package com.cvte.common;

/**
 * @author linxiaoyi
 * @date 2019/4/29
 */
public class StaticConfig {

    /**
     * token有效期,单位s
     */
    public static final Integer TOKEN_LIFECYCLE = 72000;

    /**
     * 短链接长度
     */
    public static final Integer SHORT_URL_LENGTH = 7;

    /**
     * url缓存默认有效期
     */
    public static final Integer URL_CACHE_EXPIRE = 259200;

    /**
     * redis缓存默认有效期
     */
    public static final Integer DEFAULT_CACHE_EXPIRE = 259200;

    /**
     * rocketmq主题
     */
    public static final String ROCKETMQ_TOPIC = "TOPIC_URL";

    /**
     * rocketmq分组id
     */
    public static final String ROCKETMQ_GROUP_ID = "GID_URL";
}
