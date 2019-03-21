package my.java;

import java.util.Iterator;
import java.util.Set;

/**
 * @author zhangjingsi
 * @date 2019/1/21下午5:33
 */
public class MyHashSetTest {
    public static void main(String[] args) {
        Set<Integer> ms1 = new MyHashSet<>();
        ms1.add(1);
        ms1.add(1);
        ms1.add(5);
        ms1.add(4);
        ms1.add(3);
        ms1.add(2);
        System.out.println("size:" + ms1.size());
        Iterator<Integer> i1 = ms1.iterator();
        while (i1.hasNext()){
            System.out.println(i1.next());
        }
        System.out.println("add:" + ms1.add(1));
        System.out.println("remove:" + ms1.remove(1));
        Iterator<Integer> i2 = ms1.iterator();
        while (i2.hasNext()){
            System.out.println(i2.next());
        }
    }
}
