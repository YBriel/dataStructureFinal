package cn.array;

public class TestArray {

    public static void main(String[] args) {
        //创建数组
        int[] array1=new int[3];
        //获取数组长度
        int length1=array1.length;
        System.out.println(length1);
        //访问数组中元素
        System.out.println(array1[1]);

        int[] arr2=new int[]{1,2,3,4};
        int[] arr3={1,2,3,4};
        System.out.println(arr3[2]);
    }
}
