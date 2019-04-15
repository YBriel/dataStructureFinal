package cn.stack;
//栈的操作
public class DATA3 {
    String name;
    int age;
}

class StackType{
    static final int MAXLEN=50;
    DATA3[] data=new DATA3[MAXLEN+1];
    int top;

    //初始化栈
    StackType StInit(){
        StackType p;
        if((p=new StackType())!=null){
            p.top=0;
            return p;
        }
        return null;
    }

    //判断是否是空栈
    boolean isEmpty(StackType s){
        boolean t;
        t=s.top==0;
        return t;
    }

    //判断满栈
    boolean isFull(StackType s){
        boolean b = s.top == MAXLEN;
        return b;
    }

    //清空栈
    void STClear(StackType s){
        s.top=0;
    }

    //释放空间
    void STFree(StackType s){
        if(s!=null){
            s=null;
        }
    }

    int pushST(StackType s,DATA3 data){
        if((s.top+1)>MAXLEN){
            System.out.print("栈溢出\n");
            return 0;
        }
        s.data[++s.top]=data;
        return 1;
    }

    //出栈操作
    DATA3 PopST(StackType s){
        if(s.top==0){
            System.out.print("栈为空！\n");
            System.exit(0);
        }
        return (s.data[s.top--]);
    }

    //读取栈
    DATA3 PeekSt(StackType s){
        if(s.top==0){
            System.out.print("栈为空\n");
            System.exit(0);
        }
        return (s.data[s.top]);
    }
}

