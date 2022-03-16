package com.infosec.txw.springboot_Demo.reactor;

import java.util.Observable;

public class ReactorJDK extends Observable {
    public static void main(String[] args) {
        ReactorJDK reactorJDK = new ReactorJDK();
        //添加观察者
        reactorJDK.addObserver(((o, arg) -> System.out.println("发生变化1")));
        reactorJDK.addObserver(((o, arg) -> System.out.println("发生变化2")));
        //数据变化
        reactorJDK.setChanged();
        //发出通知
        reactorJDK.notifyObservers();


    }
}
