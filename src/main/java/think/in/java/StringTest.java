package think.in.java;


import java.util.*;

/**
 * @author zhangjingsi
 * @date 2018/12/25下午6:00
 */
public class StringTest {
    public static void main(String[] args) {
        //String s2 = "aa";
        StringTest st = new StringTest();
        String s1 = new String("a") + new String("a");

        s1.intern();
        String s3 = "aa";
        System.out.println(s3 == s1);
        //System.out.println(s2 == s3);
        Map<String, String> m1 = new HashMap<>(1);
        List<String> l1 = new ArrayList<>();
        Set<String> s2 = new HashSet<>();

    }
}
