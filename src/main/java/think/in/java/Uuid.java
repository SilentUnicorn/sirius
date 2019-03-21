package think.in.java;

import java.util.UUID;

/**
 * @author zhangjingsi
 * @date 2019/3/11下午5:33
 */
public class Uuid {
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            System.out.println(UUID.randomUUID());
        }
    }
}
