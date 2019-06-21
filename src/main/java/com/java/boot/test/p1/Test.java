package com.java.boot.test.p1;



import java.lang.reflect.Proxy;


/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/21 20:12
 * @Description: No Description
 */
public class Test {
    public static void main(String[] args) {
        //实例化实现类，相当于原始的方法
        SearchGirl searchGirl=new SearchGirl();
        //得到当前类加载器对象
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        //得到代理方法的接口
        Class<?>[] classes = searchGirl.getClass().getInterfaces();
        //被代理的委托类，
        ProxySearch proxySearch=new ProxySearch(searchGirl);
        Search s = (Search)Proxy.newProxyInstance(classLoader,classes,proxySearch);
        s.searchGirl("RSD","1","1");
    }
}
