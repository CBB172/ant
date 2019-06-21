package com.java.boot.test.p2;



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
        Search search = ProxySearch.searchGirl(Search.class);
        search.searchGirl("1","2","3");
    }
}
