package com.infosec.txw.springboot_Demo.proxy;

import com.infosec.txw.springboot_Demo.aop.AOP;
import com.infosec.txw.springboot_Demo.service.Iservice;

public class AopProxy implements Iservice {

    //被代理类
    private Iservice service;
    //切面
    private AOP aop;

    public AopProxy(Iservice service, AOP aop) {
        this.service = service;
        this.aop = aop;
    }

    public void service() {
        try {
            aop.before();
            service.add(1,2); //核心业务
            aop.after();
        } catch (Exception e) {
            aop.exception();
        } finally {
            aop.myfinally();
        }
    }

    @Override
    public void add(int a, int b) {
        try {
            aop.before();
            service.add(a,b); //核心业务
            aop.after();
        } catch (Exception e) {
            aop.exception();
        } finally {
            aop.myfinally();
        }
    }

    @Override
    public void delete(int a, int b) {
        try {
            aop.before();
            service.delete(a,b); //核心业务
            aop.after();
        } catch (Exception e) {
            aop.exception();
        } finally {
            aop.myfinally();
        }
    }
}
