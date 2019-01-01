package think.in.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjingsi
 * @date 2019/1/1下午4:30
 *
 * 二者的区别就是「数组」和「双向链表」的区别
 * ArrayList 在某个 index 下插入元素的速度比较慢，以为涉及到元素的移动
 * LinkedList 在某个 index 下插入元素的速度比较快，只需要修改 next 和 prev 指针
 * 查找时：ArrayList 非常快，通过下标即可找到对应元素，而 LinkedList 需要通过指针依次遍历获取
 */
public class ArrayListVsLinkedList {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            List<Integer> l1 = new ArrayList<>();
            long start = System.currentTimeMillis();
            for(int i = 0; i < 500000; i++){
                l1.add(0, i);
            }
            System.out.println("ArrayList add cost :" + (System.currentTimeMillis() - start));

            long start1 = System.currentTimeMillis();
            l1.get(300000);
            System.out.println("ArrayList get cost :" + (System.currentTimeMillis() - start1));
        });
        Thread t2 = new Thread(() -> {
            List<Integer> l1 = new LinkedList<>();
            long start = System.currentTimeMillis();
            for(int i = 0; i < 5000000; i++){
                l1.add(0, i);
            }
            System.out.println("LinkedList add cost :" + (System.currentTimeMillis() - start));

            long start1 = System.currentTimeMillis();
            l1.get(300000);
            System.out.println("LinkedList get cost :" + (System.currentTimeMillis() - start1));
        });
        t1.start();
        t2.start();
    }
}
