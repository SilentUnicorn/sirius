package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjingsi
 * @date 2018/7/26上午11:42
 */
public class SwitchCase {
    /***
     * 当case没有break的时候，匹配到之后，会执行当前case以后后面所有case的代码
     * @param args
     */
    public static void main(String[] args) {
        int a = 1;
        switch (a){
            case 1: System.out.println("1");
            case 2: System.out.println("2");
            case 3: System.out.println("3");
            default: System.out.println("default");
        }

        String s1 = "1,2,3,4, ,";
        String[] s = s1.split(",");
        System.out.println(s.length);
        for(int i = 0; i < s.length; i++){
            System.out.println(s[i]);
        }
        System.out.println("end");

        Map<Long, Integer> m = new HashMap();
        m.put(63892L, 1);
        m.put(63893L, 1);
        m.put(63894L, 2);
        m.put(63895L, 2);
        System.out.println(m.toString());
    }
}
