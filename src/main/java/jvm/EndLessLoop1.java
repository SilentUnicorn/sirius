package jvm;

import org.apache.commons.collections4.map.AbstractReferenceMap;
import org.apache.commons.collections4.map.ReferenceMap;

import java.util.Map;

public class EndLessLoop1 {
    private static Map<String, String> cache = new ReferenceMap<>(AbstractReferenceMap.ReferenceStrength.SOFT, AbstractReferenceMap.ReferenceStrength.SOFT, 65535, 1);

    public static void main(String[] args) {
        System.out.println("fill start");
        for (int i = 0; i < 65535; i++){
            cache.put(i+"",i+"");
        }
        System.out.println("fill end");
        Thread t1 = new Thread(()->cache.put("t1", "0"));
        Thread t2 = new Thread(()->cache.put("t2", "0"));
        t1.start();
        t2.start();
        System.out.println(cache.get("t1"));
        System.out.println(cache.get("t2"));
        System.out.println("end");
    }
}
