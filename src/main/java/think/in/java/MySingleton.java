package think.in.java;

import java.util.Objects;

/**
 * @author zhangjingsi
 * @date 2019/1/25下午4:02
 */
public class MySingleton {
    private static volatile MySingleton mySingleton;
    public static MySingleton getInstance(){
        if (Objects.isNull(mySingleton)){
            synchronized (MySingleton.class){
                if (Objects.isNull(mySingleton)){
                    mySingleton = new MySingleton();
                }
            }
        }
        return mySingleton;
    }
}
