package com.infosec.txw.springboot_Demo.proxy;

import com.infosec.txw.springboot_Demo.aop.AOP;
import com.infosec.txw.springboot_Demo.aop.LogAop;
import com.infosec.txw.springboot_Demo.aop.TransitionAop;
import com.infosec.txw.springboot_Demo.service.Iservice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {
    public static void main(String[] args) {
        //生成代理类对象
        TeamService teamService = new TeamService();
        //生成AOP切面
        TransitionAop transitionAop = new TransitionAop();
        LogAop logAop = new LogAop();
        Iservice service1 = getIservice(teamService, logAop);
        service1.add(1,2);
        service1.delete(2,1);
        Iservice service2 = getIservice(service1, transitionAop);
        System.out.println("再次增强后——————————————————————————————");
        service2.add(1,2);
        service2.delete(2,1);
    }

    private static Iservice getIservice(Iservice service, AOP aop) {

        //生成代理对象
        Iservice serviceProxy = (Iservice) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        try {
                            aop.before();
                            Object invoke = method.invoke(service, objects);
                            aop.after();
                            return invoke;
                        } catch (IllegalAccessException e) {
                            aop.exception();
                            return null;
                        } finally {
                            aop.myfinally();
                        }

                    }
                });
        return serviceProxy;
    }
}
