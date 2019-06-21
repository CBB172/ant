package com.java.boot.test.p1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/21 20:09
 * @Description: No Description
 */
public class ProxySearch implements InvocationHandler {

    private Object object;

    public ProxySearch(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("僚机在帮你撩妹...");
        for (Object arg : args) {
            System.out.println(arg);
        }
        Object invoke = method.invoke(object, args);
        System.out.println("僚机帮你撩到了妹纸...");
        return invoke;
    }

}
