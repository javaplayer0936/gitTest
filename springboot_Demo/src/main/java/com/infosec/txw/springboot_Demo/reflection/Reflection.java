package com.infosec.txw.springboot_Demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*Class<Person> personClass1 = Person.class;
        System.out.println(personClass1);

        Person person = new Person();
        Class<? extends Person> personClass2 = person.getClass();
        System.out.println(personClass2);*/

        Class<?> aClass = Class.forName("com.infosec.txw.springboot_Demo.Person");
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        Method setName = aClass.getMethod("setName", String.class);
        Method setAge = aClass.getDeclaredMethod("setAge", Integer.class);
        setAge.setAccessible(true);
        setName.invoke(o, "张三");
        setAge.invoke(o, 18);
        System.out.println(o);


    }
}
