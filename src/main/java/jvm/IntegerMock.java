package jvm;

/**
 * @author zhangjingsi
 * @date 2018/7/2下午2:07
 */
public class IntegerMock {
    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4);
    }
}
