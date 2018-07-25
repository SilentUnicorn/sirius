package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjingsi
 * @date 2018/5/2下午2:35
 */
public class ReferenceMock {
    private ReferenceMock referenceMock;
    private byte[] big = new byte[1024*1024];
    //private static ReferenceMock r = new ReferenceMock();

    public static void main(String[] args) {
        ReferenceMock referenceMock1 = new ReferenceMock();
        ReferenceMock referenceMock2 = new ReferenceMock();
        referenceMock1.referenceMock = referenceMock2;
        referenceMock2.referenceMock = referenceMock1;
        System.out.println("referenceMock1:"+referenceMock1);
        System.gc();
        referenceMock1 = null;
        referenceMock2 = null;
        System.gc();
    }
}
