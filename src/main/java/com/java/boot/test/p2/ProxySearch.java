package com.java.boot.test.p2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/21 20:09
 * @Description: No Description
 */
public class ProxySearch implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("僚机在帮你撩妹...");
        for (Object arg : args) {
            System.out.println(arg);
        }
        System.out.println(method.getName());
        for (Object o:method.getParameters()){
            System.out.println(o.toString());
        }
        System.out.println("僚机帮你撩到了妹纸...");
        return null;
    }

    public static <T,FacadeProxy> T searchGirl (Class<T> cla){
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = new Class[]{cla};
        return (T) Proxy.newProxyInstance(classLoader, classes, new ProxySearch());
    }
}
