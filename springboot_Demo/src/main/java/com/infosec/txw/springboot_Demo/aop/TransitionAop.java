package com.infosec.txw.springboot_Demo.aop;

public class TransitionAop implements AOP{
    @Override
    public void before() {
        System.out.println("开始事务");
    }

    @Override
    public void after() {
        System.out.println("提交事务");
    }

    @Override
    public void exception() {
        System.out.println("异常事务");
    }

    @Override
    public void myfinally() {
        System.out.println("最终事务");
    }
}
