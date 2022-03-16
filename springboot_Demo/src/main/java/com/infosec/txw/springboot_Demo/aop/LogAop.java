package com.infosec.txw.springboot_Demo.aop;

public class LogAop implements AOP{
    @Override
    public void before() {
        System.out.println("开始日志");
    }

    @Override
    public void after() {
        System.out.println("提交日志");
    }

    @Override
    public void exception() {
        System.out.println("异常日志");
    }

    @Override
    public void myfinally() {
        System.out.println("最终日志");
    }
}
