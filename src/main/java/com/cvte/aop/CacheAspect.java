package com.cvte.aop;

import com.cvte.annotation.RedisCache;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Method;

/**
 * @author linxiaoyi
 * @date 2019/5/22
 */
/*@Component
@Aspect
@Order(2)*/
public class CacheAspect {

    private Logger logger = LoggerFactory.getLogger(CacheAspect.class);

    private Jedis jedis = new Jedis("127.0.0.1", 6379, 500);

    public Object execute(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        try {
            Method method = getMethod(proceedingJoinPoint);
            RedisCache redisCache = method.getAnnotation(RedisCache.class);
            switch (redisCache.cacheOperation()) {
                case SELECT:
                    break;
                case UPDATE:
                    break;
                case INSERT:
                    break;
                default:
                    result = proceedingJoinPoint.proceed();
                    break;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }

    private Method getMethod(JoinPoint joinPoint) throws Exception {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        return methodSignature.getMethod();
    }
}
