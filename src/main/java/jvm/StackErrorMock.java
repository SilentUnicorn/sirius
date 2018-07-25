package jvm;

/**
 * @author zhangjingsi
 * @date 2018/4/16下午4:51
 * StackOverflowError
 * 这里有一个小细节需要注意，catch 捕获的是 Throwable，
 * 而不是 Exception。因为 StackOverflowError 和
 * OutOfMemoryError 都不属于 Exception 的子类
 * -Xss256k
 */
public class StackErrorMock {
    public static int index = 1;
    public static void main(String[] args) {
        call();
    }
    private static void call(){
        index++;
        try {
            call();
        } catch (Throwable e) {
            System.out.println("Stack deep:"+index);
            e.printStackTrace();
            return;
        }
    }
}
