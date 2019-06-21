package com.java.boot.Annontation;

import java.lang.reflect.Field;

public class aall {
    public static void zhujie(Class<?> class1) {
        String name="名称：";
        String color="颜色：";
        String address="供应商信息：";
        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
           
        }
    }
}