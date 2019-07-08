package com.java.boot.gobang.service;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/28 10:40
 * @Description: No Description
 */
public class GoBangImpl {

    private static Map<String,Integer> mapValue=new HashMap<>();

    private static byte ourPieces=1;//黑棋
    private static byte enemyPieces=2;//白棋

    private static byte width=25;//宽度
    private static byte height=25;//高度
    private static byte[][] board=new byte[width][height];//棋盘二维数组
    private static byte[][] ourPiecesInfect=new byte[width][height];//我方棋子影响力
    private static byte[][] enemyPiecesInfect=new byte[width][height];//敌方棋子影响力
    private static byte[][] ourSpaceInfect=new byte[width][height];//我方空间影响力
    private static byte[][] enemySpaceInfect=new byte[width][height];//敌方空间影响力

    private static final byte calDepth=5;//单个棋子计算深度[不包括当前棋子]
    private static final short basicValue= (short) Math.pow(2,calDepth);
    /*
    * ^ Y
    * |.
    * |3
    * |2
    * |1 2 3 4 5 ...
    * |——————————————————> X
    * ^ boardY
    * |
    * |   sx  sy
    * | /      \
    * | ——————> boardX
    * */

    static {
        //暂不考虑先手33446国际规则
        //_________ *总度*    *权重*        *加上一级活度*        *单子活度率*(是否加后续权重需判断外围棋子) *双子活度率*
        //000010000 | 5 | 32             | [[0]]                   1、0.8、0.6、0.4、0.2、         |
        //000011000 | 4 | 32*32          | [[1,1]]                 1、0.75、0.5、0.25、            |
        //000010100 | 4 | 32*32          | [[1,1]]                 1、0.75、0.5、0.25、0、         |
        //000010010 | 4 | 32*32          | [[1,1]]                 1、0.75、0.5、0.25、0、         |
        //000010001 | 4 | 32*32          | [[1,1]]                 1、0.75、0.5、0.25、0、         |
        //000011100 | 3 | 32*32*32       | [[1,1,11,11]]           1、0.66、0.33、                 |
        //000011010 | 3 | 32*32*32       | [[1,1,11,101]]          1、0.66、0.33、0、              |
        //000011001 | 3 | 32*32*32       | [[1,1,11,1001]]         1、0.66、0.33、0、              |
        //000010101 | 3 | 32*32*32       | [[1,1,101,101]]         1、0.66、0.33、0、              |
        //000011110 | 2 | 32*32*32*32    | [[1,11,111,111,11,1]]   1、                            |
        //000011101 | 2 | 32*32*32*32    | [[1,11,111,1101,101,1]] 1、0、                         |
        //000011011 | 2 | 32*32*32*32    | [[1,11,1011,1011,11,1]] 1、0、                         |
        //000011111 | 1 | 32*32*32*32*32 | [[%]]                   %                             |

        //初始化棋盘【本来为1-25,1-25———>>>0-24,0-24】
        for (int i = 0; i < board.length; i++) {
            for (int j = 0;  j< board[i].length; j++) {
                board[i][j]=0;
                ourPiecesInfect[i][j]=0;
                ourSpaceInfect[i][j]=0;
                enemyPiecesInfect[i][j]=0;
                enemySpaceInfect[i][j]=0;
            }
        }
    }

    private static void start(){

        boardPerview();

    }
    private static void boardPerview(){
        short calCount=0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]!=0){
                    calCount++;
                    calPiecesInfect(i,j);//0,24 - 0,24;
                }
            }
        }
        if(calCount==0){
            //自己先手
            System.out.println("...");
        }else {
            //统计计算量
            System.out.println("...");
        }

    }

    public static void main(String[] args) {

    }

    private static void ifEnd(){

    }

    private static void calPiecesInfect(int x,int y){
        //根据X计算 [ 3 , 2 ]
        //以当前棋子为中，延伸calDepth深度
        // y=0 0 1 5 #6 ,   y=4 4 1 5 #10 ,   y=5 5 1 5 #11

        if(x>=0&&y>=0){
            byte dep= (byte) (((y > calDepth ) ? calDepth : y ) + 1 + calDepth);
            byte[] bytes=new byte[dep];
            //获取此行棋子数据
            for (int i = 0; i <dep ; i++) {
                // y=0 dep=6 range=0-5 ,   y=1 dep=7 range=0-6  ,   y=4 dep=10 range=0-9 , y=5 dep=11 range=0-10 , y=6 dep=11 range=1-11
                bytes[i]= board[x][ y - ((y>calDepth)?calDepth:y)+i];
            }
            System.out.println("计算深度："+bytes.length+";当前元素位置"+x+","+y);
            System.out.println(Arrays.toString(bytes));
            if(board[x][y]==ourPieces){
                //棋子下标 [0, 1, 2, 3, 4, 5, 6, 7, 8]
                //棋子环境 [0, 0, 1, 0, 2, 1, 0, 1, 2]
                for (int i = 0; i < bytes.length; i++) {

                }
            }else if (board[x][y]==enemyPieces){
                //这是敌方棋子

            }else {
                System.out.println("x y 值异常！"+x+","+y);
            }
        }else {
            System.out.println("x y 值异常！"+x+","+y);
        }
    }

}
