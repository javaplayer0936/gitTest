package com.infosec.txw.springboot_Demo.proxy;

import com.infosec.txw.springboot_Demo.service.Iservice;

public class TransitionProxy implements Iservice {

    //核心业务类
    private Iservice service;

    public TransitionProxy(Iservice service){
        this.service = service;
    }

    @Override
    public void add(int a, int b) {
        try {
            System.out.println("开始事务");
            service.add(a,b);
            System.out.println("提交事务");
        } catch (Exception e) {
            System.out.println("回滚事务");
        }
    }

    @Override
    public void delete(int a, int b) {
        try {
            System.out.println("开始事务");
            service.delete(a,b);
            System.out.println("提交事务");
        } catch (Exception e) {
            System.out.println("回滚事务");
        }
    }
}
