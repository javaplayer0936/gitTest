package com.infosec.txw.springboot_Demo.proxy;

import com.infosec.txw.springboot_Demo.service.Iservice;

public class TeamService implements Iservice {

    @Override
    public void add(int a, int b) {
        System.out.println("核心业务1——————————值"+ (a + b));
    }

    @Override
    public void delete(int a, int b) {
        System.out.println("核心业务2——————————值"+ (a - b));

    }
}
