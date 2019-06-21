package com.java.boot.jdk2;

public class penImpl implements penInter{

    @Override
    public Integer addPen() {
        System.out.println("增加了一本图书！！");
        return 1;
    }
    
}