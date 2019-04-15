package cn.cltype;

public class DATA2 {
    String key;
    String name;
    int age;
}

class ClType {
     DATA2 nodeData = new DATA2();
    ClType nextNode;

    /**
     * 末尾添加结点
     *
     * @param head
     * @param nodeData
     * @return
     */
    ClType CLAddEnd(ClType head, DATA2 nodeData) {
        ClType node, htemp;
        if ((node = new ClType()) == null) {
            System.out.println("申请内存失败！\n");
            return null;
        } else {
            node.nodeData = nodeData;
            node.nextNode = null;
            if (head == null) {
                head = node;
                return head;
            }
            htemp = head;
            while (htemp.nextNode != null) {
                htemp = htemp.nextNode;
            }
            htemp.nextNode = node;
            return head;
        }
    }

    /**
     * 添加头结点
     *
     * @param head
     * @param nodeData
     * @return
     */
    ClType ClAddFirst(ClType head, DATA2 nodeData) {
        ClType node;
        if ((node = new ClType()) == null) {
            System.out.println("申请内存失败！\n");
            return null;
        } else {
            node.nodeData = nodeData;
            node.nextNode = head;
            head = node;   //头引用指向新增结点
            return head;
        }
    }

    //查找结点
    ClType ClFindNode(ClType head, String key) {
        ClType htemp;
        htemp = head;
        while (htemp != null) {
            if (htemp.nodeData.key.compareTo(key) == 0) {
                return htemp;
            }
            htemp = htemp.nextNode;
        }
        return null;
    }

    //插入结点 1.申请内存，保存新增的结点，找到要插入的逻辑位置，修改引用
    ClType CLInsertNode(ClType head, String findkey, DATA2 nodeData) {
        ClType node, nodetemp;
        if ((node = new ClType()) == null) {
            System.out.println("申请内存失败！\n");
            return null;
        }
        node.nodeData = nodeData;
        nodetemp = ClFindNode(head, findkey);
        if (nodetemp != null) {
            node.nextNode = nodetemp.nextNode;
            nodetemp.nextNode = node;
        } else {
            System.out.println("未找到正确的位置！\n");
        }
        return head;
    }

    //删除结点
    int CLDeleteNode(ClType head, String key) {
        ClType node, htemp;
        htemp = head;
        node = head;
        while (htemp != null) {
            if (htemp.nodeData.key.compareTo(key) == 0) {
                node.nextNode = htemp.nextNode;
                htemp = null;
                return 1;
            } else {
                node = htemp;
                htemp = htemp.nextNode;
            }
        }
        return 0;
    }

    //计算链表长度
    int CLLength(ClType head) {
        ClType htemp;
        int len = 0;
        htemp = head;
        while (htemp != null) {
            len++;
            htemp = htemp.nextNode;
        }
        return len;
    }

    //显示所有的结点
    void CLShowAll(ClType head) {
        ClType htemp;
        DATA2 nodeData;
        htemp = head;
        System.out.printf("当前链表共有%d个结点，链表所有数据如下：\n", CLLength(head));
        while (htemp != null) {
            nodeData = htemp.nodeData;
            System.out.printf("结点(%s,%s,%d)\n", nodeData.key, nodeData.name, nodeData.age);
            htemp = htemp.nextNode;
        }
    }

    void CLShowAll1(ClType head){
        DATA2 nodeData;
        System.out.printf("当前链表共有%d个结点，链表所有数据如下：\n", CLLength(head));
        while (head!=null){
            nodeData=head.nodeData;
            System.out.printf("结点(%s,%s,%d)\n", nodeData.key, nodeData.name, nodeData.age);
            head=head.nextNode;
        }
    }
}


