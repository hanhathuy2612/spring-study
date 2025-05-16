package com.huy.spring_study.custom_transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class CustomTransactionalAspect {

    private final CustomTransactionManager transactionManager;

    @Around("@annotation(CustomTransactional)")
    public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("=====================> TRANSACTION START <=====================");
        transactionManager.begin(); // Start "transaction"
        try {
            Object result = joinPoint.proceed(); // Execute the method
            transactionManager.commit(); // Commit if
            return result;
        } catch (Throwable e) {
            transactionManager.rollback(); // Rollback on any exception
            throw e; // Re-throw the exception
        }
    }
}
