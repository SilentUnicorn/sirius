package jvm;

import org.apache.commons.collections4.map.AbstractReferenceMap;
import org.apache.commons.collections4.map.ReferenceMap;

import java.util.Map;

public class EndLessLoop {
    private static Map<String, String> cache = new ReferenceMap<>(AbstractReferenceMap.ReferenceStrength.SOFT, AbstractReferenceMap.ReferenceStrength.SOFT, 3, 1);


    public static void main(String[] args) {
        for (int i=0; i < 1000; i ++){
            EndLessLoop endLessLoop = new EndLessLoop();
            endLessLoop.run();
        }
    }

    public void run() {
        System.out.println("start...");
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 10; j ++){
                    cache.put(finalI + "" + j, "thread");
                }
            }).start();
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j ++){
                System.out.println(cache.get(i + "" + j));
            }
            System.out.println(cache.get(i + ""));
        }
        System.out.println("end");
    }
}
