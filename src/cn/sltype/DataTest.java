package cn.sltype;

import java.util.Scanner;

public class DataTest {
    public static void main(String[] args) {
        int i;
        SLTYPE sltype=new SLTYPE();
        DATA pdata;
        String key;
        System.out.println("顺序表操作演示！\n");
        sltype.SLinit(sltype);
        System.out.println("顺序表初始化完毕！\n");
        Scanner sc=new Scanner(System.in);
        do
            {
            System.out.println("请输入添加的结点（学号，姓名，年龄) : ");
            DATA data=new DATA();
            data.key=sc.next();
            data.name=sc.next();
            data.age=sc.nextInt();
            if(data.age!=0) {
                //如果添加失败则退出循环
                if (sltype.SLAppend(sltype, data) == 0) {
                    break;
                }
            }else {
                    break;
                }
            }while (true);
            System.out.println("顺序表中的结点顺序为：\n");
            sltype.SLShow(sltype);
            System.out.println("\n要取出的结点的序号：");
            i=sc.nextInt();
            pdata=sltype.findByNum(sltype,i);
            if(pdata!=null){
                System.out.printf("第%d个结点为：(%s,%s,%d)\n",i,pdata.key,pdata.name,pdata.age);
            }

            System.out.println("\n要查找结点的关键字：");
            key=sc.next();
            i=sltype.findByCont(sltype,key);
            pdata=sltype.findByNum(sltype,i);
            if(pdata!=null){
                System.out.printf("第%d个结点为：(%s,%s,%d)\n",i,pdata.key,pdata.name,pdata.age);
            }
        }

}
