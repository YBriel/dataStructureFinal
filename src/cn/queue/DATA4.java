package cn.queue;

/**
 * 顺序队列
 * sequenceQueue
 */
public class DATA4 {
    String name;
    int age;
}

class SQType {
    public static final int MAXLEN = 50;
    DATA4[] data4 = new DATA4[MAXLEN];
    int head;
    int tail;

    //初始化
    SQType initSQ() {
        SQType q;
        if ((q = new SQType()) != null) {
            q.head = 0;
            q.tail = 0;
            return q;
        } else {
            return null;
        }
    }

    //判断空队列
    int sqTypeIsEmpty(SQType q) {
        if (q.head == q.tail) {
            return 1;
        }
        return 0;
    }

    //判断满队列
    int sqTypeIsFull(SQType q) {
        if (q.tail == MAXLEN) {
            return 1;
        }
        return 0;
    }

    //清空队列
    void sqTypeClear(SQType q) {
        q.head = 0;
        q.tail = 0;
    }

    //释放空间
    void sqlTypeFree(SQType q) {
        if (q != null) {
            q = null;
        }
    }

    //入队列
    int sqTypeIn(SQType q, DATA4 data) {
        //判断队列是否满了
        if (q.tail == MAXLEN) {
            System.out.println("队列已满，无法进行添加！\n");
            return (0);
        } else {
            q.data4[q.tail++] = data;
            return (1);
        }
    }

    //出队列
    DATA4 sqTypeOut(SQType q) {
        //判断是否是空队列
        if (q.head == q.tail) {
            System.out.println("队列为空，无法进行出队列！\n");
            System.exit(0);
        } else {
            return q.data4[q.head++];
        }
        return null;
    }

    //读取结点数据
    DATA4 sqTypePeek(SQType q) {
        if (sqTypeIsEmpty(q) == 1) {
            System.out.println("队列为空！");
            return null;
        } else {
            return q.data4[q.head];
        }
    }

    //计算长度
    int sqTypeLen(SQType q) {
        int i = q.tail - q.head;
        return i;
    }

}
