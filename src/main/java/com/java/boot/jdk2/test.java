package com.java.boot.jdk2;

public class test {

    public static void main(String[] args) {
        
        bookImpl bookImpl = new bookImpl();

        book book = (com.java.boot.jdk2.book) bookImpl.bind(new bookin());

        book.addbookInteger();

        penInter penInter = (com.java.boot.jdk2.penInter) bookImpl.bind(new penImpl());

        penInter.addPen();
    }

}