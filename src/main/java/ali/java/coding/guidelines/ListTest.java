package ali.java.coding.guidelines;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjingsi
 * @date 2018/8/7上午11:22
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");
        String[] array = new String[list.size()];
        array = list.toArray(array);
        List<String> list1 = new ArrayList<>();
        /**Arrays.asList返回的是Arrays的一个内部类 ArrayList 并不是我们经常用的java.util.ArrayList ，而且这个内部类 ArrayList 虽然集成了 AbstractList 但并未覆盖add等操作方法，而 AbstractList.add
         * 等操作方法是直接抛异常 此时异常的作用并不是处理不了，而是起到一个通知的作用*/

        list1 = Arrays.asList(array);
        list1.add("g");
        System.out.println(list1);
    }
}

class ListTest1{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String item : list){
            System.out.println(item);
            /**条件为1时，第一个 item 是1，移除之后进入下一次循环，调用 hasNext() 发现 cursor = size 就不会进行下一次循环了*/
            /**别在foreach中用list 的remove就是了，要用也就用 Iterator.remove，机制是为了保证 Fail-Fast，多线程操作时直接抛异常。*/
            if ("1".equals(item)){
                list.remove(item);
            }
            System.out.println("1111"+list);
        }
        System.out.println(list);
    }
}
