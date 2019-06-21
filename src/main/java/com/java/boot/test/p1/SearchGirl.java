package com.java.boot.test.p1;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/21 20:07
 * @Description: No Description
 */
public class SearchGirl implements Search {

    @Override
    public void searchGirl(String who, String yanzhi, String shencai) {
        System.out.println(who+"找颜值为"+yanzhi+"分的，身材为"+shencai+"分的妹纸");
    }
}
