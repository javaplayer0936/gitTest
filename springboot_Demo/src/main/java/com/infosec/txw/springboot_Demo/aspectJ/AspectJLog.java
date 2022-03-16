package com.infosec.txw.springboot_Demo.aspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class AspectJLog {

    @Pointcut(value = "execution(public void *..ServiceAspectJ+.*(..))")
    public void pointcut(){

    }

    @Before(value = "pointcut()")
    public void before() {
        System.out.println("开始日志");
    }

    @AfterReturning(value = "pointcut()")
    public void after() {
        System.out.println("提交日志");
    }

    @AfterThrowing(value = "pointcut()")
    public void exception() {
        System.out.println("回滚日志");
    }

    @After(value = "pointcut()")
    public void myfinally() {
        System.out.println("最终日志");
    }

    @Around(value = "pointcut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后");
    }

}
