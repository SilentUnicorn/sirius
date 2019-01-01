package think.in.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author zhangjingsi
 * @date 2019/1/1下午5:33
 *
 * ArrayList 和 LinkedList 结果异常，非线程安全
 * Vector 线程安全
 */
public class ArrayListNonThreadSafe {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> l1= new ArrayList<>();
        Thread t1 = new Thread(() -> {
           for(int i = 0; i < 100; i ++){
               l1.add(i);
               try {
                   Thread.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        Thread t2 = new Thread(() -> {
            for(int i = 100; i < 200; i ++){
                l1.add(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(3000);
        System.out.println(l1.size());
        System.out.println(l1.toString());
    }
}
