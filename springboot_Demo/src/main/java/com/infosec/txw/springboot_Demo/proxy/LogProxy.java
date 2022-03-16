package com.infosec.txw.springboot_Demo.proxy;

import com.infosec.txw.springboot_Demo.service.Iservice;

public class LogProxy implements Iservice {
    //核心业务类
    private Iservice service;

    public LogProxy(Iservice service){
        this.service = service;
    }

    @Override
    public void add(int a, int b) {
        try {
            System.out.println("开始日志");
            service.add(a,b);
            System.out.println("提交日志");
        } catch (Exception e) {
            System.out.println("回滚日志");
        }
    }

    @Override
    public void delete(int a, int b) {
        try {
            System.out.println("开始日志");
            service.delete(a,b);
            System.out.println("提交日志");
        } catch (Exception e) {
            System.out.println("回滚日志");
        }
    }
}
