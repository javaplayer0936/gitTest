package com.infosec.txw.springboot_Demo.service;

import com.sun.istack.internal.NotNull;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
//@Transactional(propagation = Propagation.REQUIRED)
public class ServiceAspectJ {

    public void add(int a, int b) {
        System.out.println("核心业务1——————————值"+ (a + b));
    }

    public void delete(int a, int b) {
        System.out.println("核心业务2——————————值"+ (a - b));
    }

    public void haha(@Nullable Integer integer) {
        System.out.println("haha");
    }
}
