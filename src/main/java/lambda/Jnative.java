package lambda;

import org.xvolks.jnative.JNative;
import org.xvolks.jnative.exceptions.NativeException;

/**
 * @author zhangjingsi
 * @date 2018/3/9下午4:42
 */
public class Jnative {
    public static void main(String[] args) throws NativeException {
        System.setProperty("jnative.loadNative", "/Users/macpro/project/sirius/libJNativeCpp.so");
        JNative getPlayUrl = new JNative("SuperComSCL2008.Dll", "getPlayUrl");
    }
}
