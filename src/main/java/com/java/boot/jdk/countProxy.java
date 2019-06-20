package com.java.boot.jdk;

public class countProxy implements count{
    private countImpl count;

    @Override
    public void queryCount() {
        System.out.println("查询处理之前");
        count.queryCount();
        System.out.println("查询处理之后");
    }

    @Override
    public void updateCount() {
        System.out.println("修改处理之前");
        count.updateCount();
        System.out.println("修改处理之后");
    }

    public countProxy(countImpl countImpl) {
        this.count = countImpl;
    }


    
}