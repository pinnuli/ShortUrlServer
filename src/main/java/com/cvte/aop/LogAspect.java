package com.cvte.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author linxiaoyi
 * @date 2019/05/21
 */
@Component
@Aspect
@Order(1)
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 功能开始时间
     */
    private long startTimeMillis = 0;

    /**
     * 功能结束时间
     */
    private long endTimeMillis = 0;

    @Around("execution(* com.cvte.controller.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("调用 " + pjp.getTarget() + " 的 " + pjp.getSignature().getName()
                + " 方法,入参:" + Arrays.toString(pjp.getArgs()));
        startTimeMillis = System.currentTimeMillis();
        Object result = pjp.proceed();
        log.info("调用 " + pjp.getTarget() + " 的 "
                + pjp.getSignature().getName() + " 方法,方法返回值:" + result.toString());
        endTimeMillis = System.currentTimeMillis();
        log.info(pjp.getSignature().getName() + " 方法执行结束! 用时："
                + (endTimeMillis - startTimeMillis) + "ms");
        return result;
    }
}
