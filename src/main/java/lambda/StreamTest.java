package lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhangjingsi
 * @date 2018/3/6下午8:00
 */
public class StreamTest {

    public static void main(String[] args) throws IOException {
        List<Apple> inventory = new ArrayList<>();
        Apple a1 = new Apple("a1",5);
        Apple a2 = new Apple("a2",3);
        Apple a3 = new Apple("a3",8);
        inventory.add(a1);
        inventory.add(a2);
        inventory.add(a3);
        inventory.stream().forEach(apple->System.out.println(apple.getName()));
        inventory.sort(Comparator.comparing(Apple::getWeigh));
        System.out.println("sort after-----------");
        inventory.stream().forEach(apple->System.out.println(apple.getName()));
        System.out.println("filter after---------");
        //并行处理
        inventory.parallelStream().filter(apple->apple.getWeigh() > 0 && apple.getWeigh() < 6).forEach(apple->System.out.println(apple.getName()));
        System.out.println("stream to list-------");
        List<String> strs = java.util.stream.Stream.of("s1","s2","s3").collect(Collectors.toList());
        strs.stream().forEach(s->System.out.println(s));
        //test1();
        Thread t = new Thread(()->{
            for(int i = 0; i < 5; i++){
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }});
        t.start();
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++){
                System.out.println("r"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //线程执行不会阻塞其他操作
        new Thread(runnable).start();
        System.out.println("end---------------");
    }

    public static void test1() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        String str = scanner.next();
        System.out.println("你输入的字符串为："+str);
    }
}
