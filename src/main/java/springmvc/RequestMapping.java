package springmvc;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjingsi
 * @date 2018/9/13下午7:52
 */
public class RequestMapping {

    private static Map<String, Class<?>> requestMap = new HashMap<>();

    public static Class<?> getClass(String path){
        return requestMap.get(path);
    }

    public static Map<String, Class<?>> getRequestMap() {
        return requestMap;
    }

    public static void put(String path, Class<?> clazz){
        requestMap.put(path, clazz);
    }
}
