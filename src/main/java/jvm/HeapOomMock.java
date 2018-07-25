package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjingsi
 * @date 2018/4/16下午5:06
 * -Xms20m -Xmx20m
 * 设置初始堆和最大堆的大小都为20m
 */
public class HeapOomMock {

    private static String param1 = "123";
    private String param2 = "qwe";
    private static final String param3 = "asd";
    private final String param4 = "zxc";
    public static void main(String[] args) {
        HeapOomMock heapOomMock = new HeapOomMock();
        heapOomMock.test();
        List<byte[]> list = new ArrayList<>();
        int counter = 0;
        boolean flag = true;
        while(flag){
            try {
                list.add(new byte[1024*1024]);
                counter++;
            } catch (Throwable e) {
                System.out.println("counter:"+counter);
                flag = false;
                e.printStackTrace();
            }
        }
    }
    private void test(){
        System.out.println(HeapOomMock.param1);
        System.out.println(this.param2);
        System.out.println(HeapOomMock.param3);
        System.out.println(this.param4);
        test2();
    }

    private static void test2(){}
}
