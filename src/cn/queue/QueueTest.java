package cn.queue;

import java.util.Scanner;

/**
 * 队列的测试
 */
public class QueueTest {

    public static void main(String[] args) {
        SQType sqType=new SQType();
        DATA4 data1;
        Scanner sc=new Scanner(System.in);
        SQType sq = sqType.initSQ();
        System.out.println("入队操作：\n");
        System.out.println("输入姓名 年龄进行入队操作：");
        do{
            DATA4 data=new DATA4();
            data.name=sc.next();
            data.age=sc.nextInt();
            if(data.name.equals("0")){
                break;
            }else {
                sqType.sqTypeIn(sq,data);
            }
        }while (true);
        String temp="1";
        System.out.println("出队列操作：按任意非零键进行出栈操作");
        temp=sc.next();
        while (!temp.equals("0")){
            data1=sq.sqTypeOut(sq);
            System.out.printf("出队列的数据为（%s,%d)\n",data1.name,data1.age);
            temp=sc.next();
        }
        System.out.println("测试结束！");
        sq.sqlTypeFree(sq);
    }
}
