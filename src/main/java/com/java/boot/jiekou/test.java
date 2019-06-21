package com.java.boot.jiekou;

public class test {
    public static void main(String[] args) {
        shixianIn shixianIn1 = invok.newMapperProxy(shixianIn.class);
        System.out.println(shixianIn1.addString(123,"蚕宝宝","出版部",true));
        System.out.println(shixianIn1.up(15468, "cbb"));
        System.out.println(shixianIn1.up1(148569, "dnsak"));
        System.out.println(shixianIn1.aa(("cfmjdiso"), 56));
    }
}