package cn.stack;

import java.util.Scanner;

public class STTest {

    public static void main(String[] args) {
        StackType st=new StackType();
        DATA3 data=new DATA3();

        StackType stackType=st.StInit();
        Scanner sc=new Scanner(System.in);
        System.out.print("入栈操作:\n");
        System.out.println("输入姓名 年龄进行入栈操作：");
        do {
            DATA3 data3=new DATA3();
            data3.name=sc.next();
            if(data3.name.equals("0")){
                break;
            }
            else {
                data3.age=sc.nextInt();
                st.pushST(stackType,data3);
            }
        }while (true);
        String temp="1";
        System.out.println("出栈操作，按任意非0键进行出栈操作：");
        temp=sc.next();
        while (!temp.equals("0")){
            data=st.PopST(stackType);
            System.out.printf("出栈的数据是（%s,%d)\n",data.name,data.age);
            temp=sc.next();
        }
        System.out.println("测试结束！ ");
        st.STFree(st);
    }
}
