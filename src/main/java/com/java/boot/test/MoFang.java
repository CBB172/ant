package com.java.boot.test;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/27 12:53
 * @Description: No Description
 */
public class MoFang {

    private static final String[] A = {"R","G","W","B","Y","O"};
    private static String[] R ={"□","□","□","□","R","□","□","□","□"};//红色
    private static String[] G ={"□","□","□","□","G","□","□","□","□"};//绿色
    private static String[] W ={"□","□","□","□","W","□","□","□","□"};//白色
    private static String[] B ={"□","□","□","□","B","□","□","□","□"};//蓝色
    private static String[] Y ={"□","□","□","□","Y","□","□","□","□"};//黄色
    private static String[] O ={"□","□","□","□","O","□","□","□","□"};//橙色
    private static int[] mn0 =new int[8];
    private static int[] mn1 =new int[8];
    private static int[] mn2 =new int[8];
    private static int[] mn3 =new int[8];
    private static int[] mn4 =new int[8];
    private static int[] mn5 =new int[8];
    public static void main(String[] args) {
        int i=0;
        nex:while(true) {
            show();
            System.out.println("请输入"+A[i]+"面的位颜色，以空格分隔!");
            Scanner scanner=new Scanner(System.in);
            String inp=scanner.next();
            String[] temp = inp.split(",");
            if(temp.length!=9){
                System.out.println("您的输入长度不为9，请重新输入！");
                continue;
            }
            for (String t:temp){
                if(!t.equals("R")&&!t.equals("G")&&!t.equals("W")&&!t.equals("B")&&!t.equals("Y")&&!t.equals("O")){
                    System.out.println("您的输入的颜色代号有误，请重新输入！");
                    continue nex;
                }
            }
            switch (A[i]){
                case "R":
                    R=temp;
                    break ;
                case "G":
                    G=temp;
                    break ;
                case "W":
                    W=temp;
                    break ;
                case "B":
                    B=temp;
                    break ;
                case "Y":
                    Y=temp;
                    break ;
                case "O":
                    O=temp;
                    break ;
                default:
                    System.out.println("A[i]值异常！");
                    break ;
            }
            i++;
            if(i>=6){
                break;
            }
        }
        //颜色面
        //   R
        // G W B Y
        //   O
        //M数字面
        //   1
        // 2 3 4 5
        //   6
        //白色单面
        //0 1 2
        //3 □ 5
        //6 7 8
        transForm();
        System.out.println("****************************************************");
        System.out.println(Arrays.toString(mn0));
        System.out.println(Arrays.toString(mn1));
        System.out.println(Arrays.toString(mn2));
        System.out.println(Arrays.toString(mn3));
        System.out.println(Arrays.toString(mn4));
        System.out.println(Arrays.toString(mn5));
        show();
        System.out.println("****************************************************");
        //2 0 3 6[1,9] 7 8
        //3 6 7 8
        //第一步，确立2面完整

    }

    private static void ass(){

    }

    private static void start(int page,int star,int end,int count){
        if(page==2){
            switch (star){
                case 0:
                    ex(mn0,mn1,mn2,mn3,mn4,count);
                    break;
                case 3:
                    in(mn1,mn2,mn3,mn4,count);
                    break;
                case 6:
                    if(end==1){
                        ex(mn1,mn5,mn2,mn0,mn4,count);
                    }else if(end==9){
                        ex(mn5,mn1,mn2,mn3,mn4,count);
                    }
                    break;
                case 7:
                    in(mn5,mn2,mn0,mn4,count);
                    break;
                case 8:
                    ex(mn3,mn5,mn2,mn0,mn4,count);
                    break;
                default:
                    System.out.println("错误代码509：未识别 star / end .");
                    break;
            }
        }else if (page==3){
            switch (star){
                case 6:
                    ex(mn2,mn5,mn3,mn0,mn1,count);
                    break;
                case 7:
                    in(mn5,mn3,mn0,mn1,count);
                    break;
                case 8:
                    ex(mn4,mn5,mn3,mn0,mn1,count);
                    break;
                default:
                    System.out.println("错误代码509：未识别 star / end .");
                    break;
            }
        }

    }

    private static List<int[]> ex(int[] a, int[] a0, int[] a1, int[] a2, int[] a3, int count){
        List<int[]> list=new ArrayList<>(5);
        //   1     |    a
        // 2 3 4 5 | a0 a1 a2 a3
        //   6     |
        if(a.length==9&&a0.length==9&&a1.length==9&&a2.length==9&&a3.length==9){
            int [] temp=new int[9];
            int [] t=new int[3];
            switch (count){
                case 1:
                    //012|258
                    //345|147
                    //678|036
                    temp[2]=a[0];
                    temp[5]=a[1];
                    temp[8]=a[2];
                    temp[1]=a[3];
                    temp[4]=a[4];
                    temp[7]=a[5];
                    temp[0]=a[6];
                    temp[3]=a[7];
                    temp[6]=a[8];
                    list.add(temp);
                    t[0]=a0[0];
                    t[1]=a0[1];
                    t[2]=a0[2];
                    a0[0]=a3[0];
                    a0[1]=a3[1];
                    a0[2]=a3[2];
                    a3[0]=a2[0];
                    a3[1]=a2[1];
                    a3[2]=a2[2];
                    a2[0]=a1[0];
                    a2[1]=a1[1];
                    a2[2]=a1[2];
                    a1[0]=t[0];
                    a1[1]=t[1];
                    a1[2]=t[2];
                    list.add(a0);
                    list.add(a1);
                    list.add(a2);
                    list.add(a3);
                    break;
                case 2:
                    //012|876
                    //345|543
                    //678|210
                    temp[8]=a[0];
                    temp[7]=a[1];
                    temp[6]=a[2];
                    temp[5]=a[3];
                    temp[4]=a[4];
                    temp[3]=a[5];
                    temp[2]=a[6];
                    temp[1]=a[7];
                    temp[0]=a[8];
                    list.add(temp);
                    t[0]=a0[0];
                    t[1]=a0[1];
                    t[2]=a0[2];
                    a0[0]=a2[0];
                    a0[1]=a2[1];
                    a0[2]=a2[2];
                    a2[0]=t[0];
                    a2[1]=t[1];
                    a2[2]=t[2];
                    t[0]=a1[0];
                    t[1]=a1[1];
                    t[2]=a1[2];
                    a1[0]=a3[0];
                    a1[1]=a3[1];
                    a1[2]=a3[2];
                    a3[0]=t[0];
                    a3[1]=t[1];
                    a3[2]=t[2];
                    list.add(a0);
                    list.add(a1);
                    list.add(a2);
                    list.add(a3);
                    break;
                case 3:
                    //012|630
                    //345|741
                    //678|852
                    temp[6]=a[0];
                    temp[3]=a[1];
                    temp[0]=a[2];
                    temp[7]=a[3];
                    temp[4]=a[4];
                    temp[1]=a[5];
                    temp[8]=a[6];
                    temp[5]=a[7];
                    temp[2]=a[8];
                    list.add(temp);
                    t[0]=a0[0];
                    t[1]=a0[1];
                    t[2]=a0[2];
                    a0[0]=a1[0];
                    a0[1]=a1[1];
                    a0[2]=a1[2];
                    a1[0]=a2[0];
                    a1[1]=a2[1];
                    a1[2]=a2[2];
                    a2[0]=a3[0];
                    a2[1]=a3[1];
                    a2[2]=a3[2];
                    a3[0]=t[0];
                    a3[1]=t[1];
                    a3[2]=t[2];
                    list.add(a0);
                    list.add(a1);
                    list.add(a2);
                    list.add(a3);
                    break;
                default:
                    System.out.println("count错误！！！");
                    break;
            }
        }
        return list;
    }

    private static List<int[]> in(int[] a0, int[] a1, int[] a2, int[] a3, int count){
        List<int[]> list=new ArrayList<>(4);
        //   1     |    a
        // 2 3 4 5 | a0 a1 a2 a3
        //   6     |
        if(a0.length==9&&a1.length==9&&a2.length==9&&a3.length==9){
            int [] t=new int[3];
            switch (count){
                case 1:
                    t[0]=a0[3];
                    t[1]=a0[4];
                    t[2]=a0[5];
                    a0[3]=a3[3];
                    a0[4]=a3[4];
                    a0[5]=a3[5];
                    a3[3]=a2[3];
                    a3[4]=a2[4];
                    a3[5]=a2[5];
                    a2[3]=a1[3];
                    a2[4]=a1[4];
                    a2[5]=a1[5];
                    a1[3]=t[0];
                    a1[4]=t[1];
                    a1[5]=t[2];
                    list.add(a0);
                    list.add(a1);
                    list.add(a2);
                    list.add(a3);
                    break;
                case 2:
                    t[0]=a0[3];
                    t[1]=a0[4];
                    t[2]=a0[5];
                    a0[3]=a2[3];
                    a0[4]=a2[4];
                    a0[5]=a2[5];
                    a2[3]=t[0];
                    a2[4]=t[1];
                    a2[5]=t[2];
                    t[0]=a1[3];
                    t[1]=a1[4];
                    t[2]=a1[5];
                    a1[3]=a3[3];
                    a1[4]=a3[4];
                    a1[5]=a3[5];
                    a3[3]=t[0];
                    a3[4]=t[1];
                    a3[5]=t[2];
                    list.add(a0);
                    list.add(a1);
                    list.add(a2);
                    list.add(a3);
                    break;
                case 3:
                    t[0]=a0[3];
                    t[1]=a0[4];
                    t[2]=a0[5];
                    a0[3]=a1[3];
                    a0[4]=a1[4];
                    a0[5]=a1[5];
                    a1[3]=a2[3];
                    a1[4]=a2[4];
                    a1[5]=a2[5];
                    a2[3]=a3[3];
                    a2[4]=a3[4];
                    a2[5]=a3[5];
                    a3[3]=t[0];
                    a3[4]=t[1];
                    a3[5]=t[2];
                    list.add(a0);
                    list.add(a1);
                    list.add(a2);
                    list.add(a3);
                    break;
                default:
                    System.out.println("count错误！！！");
                    break;
            }
        }
        return list;
    }

    private static void transForm(){
        Map<Integer,String[]> map=new HashMap<>();
        map.put(0,R);
        map.put(1,G);
        map.put(2,W);
        map.put(3,B);
        map.put(4,Y);
        map.put(5,O);
        map.forEach((k,v)->{
            int[] ints=new int[9];
            for (int j = 0; j < v.length; j++) {
                switch (v[j]){
                    case "R":
                        ints[j]=0;
                        break ;
                    case "G":
                        ints[j]=1;
                        break ;
                    case "W":
                        ints[j]=2;
                        break ;
                    case "B":
                        ints[j]=3;
                        break ;
                    case "Y":
                        ints[j]=4;
                        break ;
                    case "O":
                        ints[j]=5;
                        break ;
                    default:
                        System.out.println("integers[j]值异常！");
                        break ;
                }
            }
            switch (k){
                case 0:
                    mn0=ints;
                    break ;
                case 1:
                    mn1=ints;
                    break ;
                case 2:
                    mn2=ints;
                    break ;
                case 3:
                    mn3=ints;
                    break ;
                case 4:
                    mn4=ints;
                    break ;
                case 5:
                    mn5=ints;
                    break ;
                default:
                    System.out.println("integers[j]值异常！");
                    break ;
            }
        });
    }

    private static void show(){
        System.out.println("___________红色___________________");
        System.out.println("|       | "+R[0]+" "+R[1]+" "+R[2]+" |       |       |");
        System.out.println("|       | "+R[3]+" "+R[4]+" "+R[5]+" |       |       |");
        System.out.println("|       | "+R[6]+" "+R[7]+" "+R[8]+" |       |       |");
        System.out.println("___绿色_____白色_____蓝色____黄色___");
        System.out.println("| "+G[0]+" "+G[1]+" "+G[2]+" | "+W[0]+" "+W[1]+" "+W[2]+" | "+B[0]+" "+B[1]+" "+B[2]+" | "+Y[0]+" "+Y[1]+" "+Y[2]+" |");
        System.out.println("| "+G[3]+" "+G[4]+" "+G[5]+" | "+W[3]+" "+W[4]+" "+W[5]+" | "+B[3]+" "+B[4]+" "+B[5]+" | "+Y[3]+" "+Y[4]+" "+Y[5]+" |");
        System.out.println("| "+G[6]+" "+G[7]+" "+G[8]+" | "+W[6]+" "+W[7]+" "+W[8]+" | "+B[6]+" "+B[7]+" "+B[8]+" | "+Y[6]+" "+Y[7]+" "+Y[8]+" |");
        System.out.println("___________橙色___________________");
        System.out.println("|       | "+O[0]+" "+O[1]+" "+O[2]+" |       |       |");
        System.out.println("|       | "+O[3]+" "+O[4]+" "+O[5]+" |       |       |");
        System.out.println("|       | "+O[6]+" "+O[7]+" "+O[8]+" |       |       |");
        System.out.println("---------------------------------");
    }
}
