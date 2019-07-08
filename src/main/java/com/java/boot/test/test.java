package com.java.boot.test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/29 13:40
 * @Description: No Description
 */
public class test {
    private static byte[][] board=new byte[25][25];//棋盘二维数组
    private static final byte calDepth=6;//单个棋子计算深度[不包括当前棋子]

    static {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0;  j< board[i].length; j++) {
                board[i][j]=(byte) j;
            }
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            calPiecesInfect(0,i);
        }
    }

    private static void calPiecesInfect(int x,int y){
        //根据X计算 [ 3 , 2 ]
        //以当前棋子为中，延伸calDepth深度
        // y=0 0 1 5 #6 ,   y=4 4 1 5 #10 ,   y=5 5 1 5 #11

        /*if(x>=0&&y>=0){
            byte dep= (byte) (((y > calDepth ) ? calDepth : y ) + 1 + calDepth);
            byte[] bytes=new byte[dep];
            //获取此行棋子数据
            for (int i = 0; i <dep ; i++) {
                // y=0 dep=6 range=0-5 ,   y=1 dep=7 range=0-6  ,   y=4 dep=10 range=0-9 , y=5 dep=11 range=0-10 , y=6 dep=11 range=1-11
                bytes[i]= board[x][ y - ((y>calDepth)?calDepth:y)+i];
            }
            System.out.println("计算深度："+bytes.length+";当前元素位置"+x+","+y);
            System.out.println(Arrays.toString(bytes));
        }*/
    }
}
