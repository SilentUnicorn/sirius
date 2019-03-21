package think.in.java;

import java.util.*;

/**
 * @author zhangjingsi
 * @date 2019/1/14下午2:31
 */
public class Operator {
    public static void main(String[] args) {
        System.out.println(1 << 1);
        System.out.println(16 >>> 1);
        System.out.println(16 >> 1);

        System.out.println(-16 >>> 1);
        System.out.println(-16 >> 1);

        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE + 1));

        Map m = new HashMap();
        m.put(null,1);
        Map m1 = new HashMap();
        for (int i = 0; i < 50; i++){
            m1.put(i, i);
        }
        m.putAll(m1);
        System.out.println(m.get(null));
        System.out.println(9 & 4);

        List<String> l1 = new LinkedList<>();
        l1.add("1");
        System.out.println(l1.indexOf(null));
        Set<String> s1 = new HashSet<>();
        s1.add("1");
        s1.add("1");
        s1.remove("1");
        System.out.println(s1.size());

        Map<String, String> m2 = new HashMap<>();
        /**增加新 key 返回 null，覆盖原有的 key 返回原有的 value*/
        String value1 = m2.put("1", "2");
        String value2 = m2.put("1", "3");
        System.out.println("value1:" + value1);
        System.out.println("value1:" + value2);
    }
}
