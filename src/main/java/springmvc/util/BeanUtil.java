package springmvc.util;

/**
 * @author zhangjingsi
 * @date 2018/9/13下午8:24
 */
public class BeanUtil {

    public static <T> T instanceClass(Class<T> clazz){
        if (!clazz.isInterface()){
            try {
                return clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
