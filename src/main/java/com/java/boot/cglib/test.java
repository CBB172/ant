package com.java.boot.cglib;

public class test {
    public static void main(String[] args) {
        bookInfenProxy bookInfenProxy = new bookInfenProxy();
        bookImpl bookImpl = (com.java.boot.cglib.bookImpl) bookInfenProxy.getInstance(new bookImpl());
        bookImpl.addBook();
        
    }
}