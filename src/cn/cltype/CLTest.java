package cn.cltype;

import java.util.Scanner;

public class CLTest {

    public static void main(String[] args) {
        ClType node,head=null;
        ClType CL=new ClType();
        String key,findkey;
        Scanner sc=new Scanner(System.in);
        System.out.print("链表测试。先输入链表中的数据，格式为：关键字 姓名 年龄\n");
        do
        {
            DATA2 nodeData=new DATA2();
            nodeData.key=sc.next();
            if(nodeData.key.equals("0")){
                break;
            }else {
                nodeData.name=sc.next();
                nodeData.age=sc.nextInt();
                head=CL.CLAddEnd(head,nodeData);
            }

        }while (true);
        CL.CLShowAll(head);
        System.out.printf("\n演示插入结点，输入插入位置的关键字：");
        findkey=sc.next();
        System.out.print("请输入需要插入的结点的数据（关键字 名字 年龄）：");
        DATA2 nodeData=new DATA2();
        nodeData.key=sc.next();
        nodeData.name=sc.next();
        nodeData.age=sc.nextInt();
        head=CL.CLInsertNode(head,findkey,nodeData);
        CL.CLShowAll(head);

        System.out.printf("\n演示删除结点，请输入要删除的关键字：");
        key=sc.next();
        CL.CLDeleteNode(head,key);
        CL.CLShowAll(head);

        System.out.printf("\n演示在链表中查找，请输入查找关键字：");
        key=sc.next();
        node=CL.ClFindNode(head,key);
        if(node!=null){
            nodeData=node.nodeData;
            System.out.printf("关键字%s对应的结点为(%s,%s,%d)\n",key,nodeData.key,nodeData.name,nodeData.age);
        }else {
            System.out.printf("在链表中未找到关键字为%s的结点！\n",key);
        }
    }
}
