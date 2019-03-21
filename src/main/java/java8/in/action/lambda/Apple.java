package java8.in.action.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangjingsi
 * @date 2018/3/6下午7:59
 */
public class Apple {
    private String name;
    private Integer weigh;

    public Apple(String name, Integer weigh) {
        this.name = name;
        this.weigh = weigh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeigh() {
        return weigh;
    }

    public void setWeigh(Integer weigh) {
        this.weigh = weigh;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", weigh=" + weigh +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(Math.random()*9+1);
        System.out.println((int)((Math.random())*9000+1000));

        List<Apple> apples = new ArrayList<>();
        Apple apple1 = new Apple("apple1", 200);
        Apple apple2 = new Apple("apple2", 100);
        Apple apple3 = new Apple("apple1", 300);
        apples.add(apple1);
        apples.add(apple2);
        apples.add(apple3);
        Map<String, Apple> map;
        map = apples.stream().filter(apple -> apple.getWeigh() > 150).collect(Collectors.toMap(Apple :: getName, apple -> apple, (k1, k2) -> k1));
        System.out.println(map.toString());
        System.out.println(apples.stream().filter(apple -> apple.getWeigh() > 150).collect(Collectors.toList()).toString());
    }
}
