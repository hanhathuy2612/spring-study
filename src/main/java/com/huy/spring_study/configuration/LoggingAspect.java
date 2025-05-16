package com.huy.spring_study.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.huy.spring_study.service.*.*(..))")
    public void servicePointcut() {
    }

    @Around("servicePointcut()")
    public Object logService(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[INFO]: [Aspect] => [Service] => [Method] [{}] [Args] [{}]", joinPoint.getSignature().getName(), joinPoint.getArgs());
        return joinPoint.proceed();
    }

    @AfterThrowing(pointcut = "servicePointcut()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        log.error("[ERROR]: [Aspect] => [Service] => [Method] [{}] [Args] [{}] [Exception] [{}]", joinPoint.getSignature().getName(), joinPoint.getArgs(), ex.getMessage());
    }
}
