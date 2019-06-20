package com.java.boot.jdk;

public class countImpl implements count{

    @Override
    public void queryCount() {
        System.out.println("查询方法");
    }

    @Override
    public void updateCount() {
        System.out.println("修改方法");
    }

}