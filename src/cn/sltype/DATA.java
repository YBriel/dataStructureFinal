package cn.sltype;

/**
 * 顺序列表
 */
public class DATA {

    String key;
    String name;
    int age;
}

class SLTYPE {
    static final int MAXLEN = 100;
    DATA[] listData = new DATA[MAXLEN + 1];
    int ListLen;

    //初始化链表
    void SLinit(SLTYPE slty) {
        slty.ListLen = 0;
    }

    //获取长度
    int SLLength(SLTYPE sltype) {
        return sltype.ListLen;
    }

    //插入节点
    int SLInsert(SLTYPE sl, int n, DATA data) {
        int i;
        if (sl.ListLen >= MAXLEN) {
            System.out.println("顺序表已满,不能插入节点！\n");
            return 0;
        }
        if (n < 0 || n > MAXLEN) {
            System.out.println("插入元素序号错误，不能插入元素！");
            return 0;
        }
        for (i = sl.ListLen; i >= n; i--) {
            sl.listData[i + 1] = sl.listData[i];
        }
        sl.listData[n] = data;
        sl.ListLen++;
        return 1;
    }

    //追加结点
    int SLAppend(SLTYPE sl, DATA data) {
        if (sl.ListLen >= MAXLEN) {
            System.out.println("顺序表已满，不能插入结点！\n");
            return 0;
        } else {
            sl.listData[sl.ListLen + 1] = data;
            sl.ListLen++;
            return 1;
        }
    }

    //删除结点
    int SLDelete(SLTYPE sl, int n) {
        int i;
        if (n < 0 || n > sl.ListLen) {
            System.out.println("输入的结点有误！");
            return 0;
        }
        for (i = n + 1; i < sl.ListLen; i++) {
            sl.listData[i] = sl.listData[i + 1];
        }
        sl.ListLen--;
        return 1;
    }

    //根据下标查找结点
    DATA findByNum(SLTYPE sltype, int num) {
        if (num < 1 || num > MAXLEN) {
            System.out.println("输入的序号有误！");
            return null;
        }
        return sltype.listData[num];
    }

    //根据关键字查找
    int findByCont(SLTYPE sltype, String key) {
        int i;
        for (i = 1; i < sltype.ListLen; i++) {
            if (sltype.listData[i].key.compareTo(key) == 0) {
                return i;
            }
        }
        return 0;
    }

    //显示所有的结点
    int SLShow(SLTYPE sltype) {
        for (int i = 1; i <= sltype.ListLen; i++) {
            System.out.printf("(%s,%s,%d)\n", sltype.listData[i].key, sltype.listData[i].name, sltype.listData[i].age);
        }
        return 0;
    }

}