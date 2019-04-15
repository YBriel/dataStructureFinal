package cn.btree;

import java.util.Scanner;

public class TestBtree {
    static Scanner input=new Scanner(System.in);

    public static void main(String[] args) {
        CBTType root=null;
        int menusel;
        Btree b=new Btree();
        root = b.InitTree();
        do{
            System.out.println("请选择菜单添加二叉树的结点\n");
            System.out.println("0.退出\t");
            System.out.println("1.添加二叉树结点\n");
            menusel=input.nextInt();
            switch (menusel){
                case 1:
                    b.addTreeNode(root);
                    break;
                case 0:
                    break;
                default:

            }
        }while (menusel!=0);

//        遍历结点
        do{
            System.out.println("请选择菜单遍历二叉树,输入0表示退出:\n");
            System.out.println("1.先序遍历DLR\t");
            System.out.println("2.中序遍历LDR\t");
            System.out.println("3.后序遍历LRD\t");
            System.out.println("4.层序遍历\n");
            menusel=input.nextInt();
            switch (menusel){
                case 0:
                    break;
                case 1:
                    System.out.println("\n先序遍历DLR的结果:");
                    b.DLRTree(root);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("\n中序LDR遍历的结果：");
                    b.LDRTree(root);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("\n后序LRD遍历的结果：");
                    b.LRDTree(root);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("\n层序遍历的结果：");
                    b.levelTree(root);
                    System.out.println();
                    break;
                default:
            }
        }while (menusel!=0);

        System.out.printf("\n二叉树深度为:%d\n",b.treeDepth(root));
        b.clearTree(root);
        root=null;
    }
}
