package cn.btree;

import java.util.Scanner;

public class Btree {
    static final int MAXLEN=20;

    static Scanner input=new Scanner(System.in);

    CBTType InitTree()
    {
        CBTType node;

        if((node = new CBTType())!=null){
            System.out.println("请先输入一个根节点数据:\n");
            node.data=input.next();
            node.left=null;
            node.right=null;
            if(node!=null){
                return node;
            }else {
                return null;
            }
        }return null;
    }

    void addTreeNode(CBTType treeNode){
        CBTType pnode,parent;
        String data;
        int menusel;
        if((pnode=new CBTType())!=null){
            System.out.println("输入二叉树结点的数据:\n");
            pnode.data=input.next();
            pnode.left=null;
            pnode.right=null;

            System.out.println("输入该结点的父节点数据:");
            data=input.next();

            parent=treeFindNode(treeNode,data);
            if(parent==null){           //未找到结点
                System.out.println("未找到该父节点！\n");
                pnode=null;
                return;
            }
            System.out.printf("1.添加到该结点到左子树\n2.添加该节点到右子树\n");
            do{
                menusel=input.nextInt();
                if(menusel==1||menusel==2){
                    if(parent==null){
                        System.out.println("不存在父节点，请先设置父节点!\n");
                    }else {
                        switch (menusel){
                            case 1:
                                if(parent.left!=null){
                                    System.out.println("该结点左子树结点不为空!\n");
                                }else {
                                    parent.left=pnode;
                                }
                            break;
                            case 2:
                                if(parent.right!=null){
                                    System.out.println("右子树结点不为空!\n");
                                }else {
                                    parent.right=pnode;
                                }
                                break;
                                default:
                                    System.out.println("你所输入的参数无效，请检查!\n");
                        }
                    }
                }
            }while (menusel!=1&&menusel!=2);
        }
    }

     CBTType treeFindNode(CBTType treeNode, String data) {
        CBTType ptr;
        if(treeNode==null){
            return null;
        }else {
            if(treeNode.data.equals(data)){
                return treeNode;
            }else {
                if((ptr=treeFindNode(treeNode.left,data))!=null){
                    return ptr;
                }else if((ptr=treeFindNode(ptr=treeNode.right,data))!=null){
                    return ptr;
                }else {
                    return null;
                }
            }
        }
    }

    CBTType treeLeftNode(CBTType treeNode){
        if(treeNode!=null){
            return treeNode.left;
        }else {
            return null;
        }
    }

    CBTType treeRightNode(CBTType treeNode){
        if(treeNode!=null){
            return treeNode.right;
        }else {
            return null;
        }
    }

    //判断空树
    int treeIsEmpty(CBTType treeNode){
        if(treeNode!=null){
            return 0;
        }else {
            return 1;
        }
    }

    //计算二叉树深度
    int treeDepth(CBTType treeNode){
        int depleft,depright;
        if(treeNode==null){
            return 0;//空树，深度为0
        }else{
            depleft=treeDepth(treeNode.left);
            depright=treeDepth(treeNode.right);
            if(depleft>depright){
                return depleft+1;
            }else {
                return depright+1;
            }
        }
    }

    //清空二叉树
    void clearTree(CBTType treeNode){
        if(treeNode !=null){
            clearTree(treeNode.left);
            clearTree(treeNode.right);
            treeNode=null;
        }
    }

    //显示结点数据
    void treeNodeData(CBTType p){
        System.out.printf("%s ",p.data);
    }

    //层序遍历
    void levelTree(CBTType treeNode){
        CBTType p;
        CBTType[] q=new CBTType[MAXLEN];//定义一个顺序栈
        int head=0,tail=0;
        if(treeNode!=null){
            tail=(tail+1)%MAXLEN;
            q[tail]=treeNode;

        }while (head!=tail){
            head=(head+1)%MAXLEN;
            p=q[head];
            treeNodeData(p);
            if(p.left!=null){
                tail=(tail+1)%MAXLEN;
                q[tail]=p.left;
            }
            if(p.right!=null){
                tail=(tail+1)%MAXLEN;
                q[tail]=p.right;
            }
        }
    }

    //先序遍历
    void DLRTree(CBTType treeNode){
        if(treeNode!=null){
            treeNodeData(treeNode);
            DLRTree(treeNode.left);
            DLRTree(treeNode.right);
        }
    }

    //中序遍历
    void LDRTree(CBTType treeNode){
        if(treeNode!=null){
            LDRTree(treeNode.left);
            treeNodeData(treeNode);
            LDRTree(treeNode.right);
        }
    }

    // 后序遍历
    void LRDTree(CBTType treeNode){
        if(treeNode!=null){
            LRDTree(treeNode.left);
            LRDTree(treeNode.right);
            treeNodeData(treeNode);
        }
    }
}
