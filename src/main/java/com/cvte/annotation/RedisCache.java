package com.cvte.annotation;

import com.cvte.common.CacheOperation;
import com.cvte.common.StaticConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 缓存注解
 * @author linxiaoyi
 * @date 2019/5/22
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCache {


    CacheOperation cacheOperation() default CacheOperation.SELECT;

    /** 过期时间 */
    int expire() default 259200;

}
