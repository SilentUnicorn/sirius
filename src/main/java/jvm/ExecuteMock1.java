package jvm;

/**
 * @author zhangjingsi
 * @date 2018/5/3上午11:50
 */
public class ExecuteMock1 {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer("s1");
        StringBuffer s2 = new StringBuffer("s2");
        StringBuffer s3 = s1.append(s2);
        System.out.println(s3);
    }
}
