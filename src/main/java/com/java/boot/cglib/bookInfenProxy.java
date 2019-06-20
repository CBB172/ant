package com.java.boot.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;


public class bookInfenProxy implements MethodInterceptor {
    private Object target;


    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {

        System.out.println("开始之前");
        arg3.invokeSuper(arg0, arg2);  
        System.out.println("开始之后");
        return null;
    }

    public Object getInstance(Object target){

        this.target = target;

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(this.target.getClass());

        enhancer.setCallback(this);

        return enhancer.create();  
        
    }
    
}