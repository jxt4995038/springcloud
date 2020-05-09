package com.example.account.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: springcloud
 * @description: 日志切面
 * @author: jiaxiaotong
 * @create: 2019-12-24 09:45
 */
@Aspect
@Component
@Order(2)
@Transactional
public class LogAspect2 {

    @Pointcut("@annotation(com.example.account.annotation.Log)")
    public void logPoint(){

    }


    @Before(value = "logPoint()")
    public void methodBefore(JoinPoint joinPoint) {
        System.out.println("2before");
    }

    @AfterReturning(value = "logPoint()",returning = "o")
    public void methodAfter(Object o) {
        System.out.println("2afer:"+o);
    }

    @AfterThrowing("logPoint()")
    public void afterThrowing() {
        System.out.println("2afterThrowing afterThrowing  rollback");
    }

    @Around("logPoint()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println("2around");
            return joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        } finally {
            System.out.println("2around");
        }
    }
}