package com.java.boot.jdk;

public class test {

    public static void main(String[] args) {
        countImpl countImpl=new countImpl();
        countProxy countProxy=new countProxy(countImpl);
        countProxy.queryCount();
        countProxy.updateCount();
    }
}