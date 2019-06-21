package com.java.boot.jiekou;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
@SuppressWarnings("unchecked")  
public class invok implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("接口方法调用开始"); 
        String[]methods = method.toGenericString().split(" ");
        String[]methods1 = methods[3].split("\\(");
        String[]methods2 = methods1[1].split(",");
        Integer number = methods2.length;
        Object resulObject = null;
        for (int i = 0; i < number; i++) {
            if (i==(number-1)) {
                String[] aa = methods2[i].split("\\)");
                System.out.println("第"+(i+1)+"个参数类型--"+aa[0]);
            } else {
                System.out.println("第"+(i+1)+"个参数类型--"+methods2[i]);
            }
            
        }
        System.out.println("返回值类型"+methods[2]); 
        System.out.println("方法名称:"+method.getName());  
        Integer num  = args.length;
        for (int i = 0; i < num; i++) {
            System.out.println("第"+(i+1)+"个参数--"+args[i]);
        }

        System.out.println("接口方法调用结束");    
        return resulObject;
    }
   

    public static <T, FacadeProxy> T newMapperProxy(Class<T> cla) {

        ClassLoader classLoader = cla.getClassLoader();
        Class<?>[] interfaces = new Class[]{ cla };
        invok proxy = new invok();

        return (T) Proxy.newProxyInstance(classLoader, interfaces,  proxy);
    }
}