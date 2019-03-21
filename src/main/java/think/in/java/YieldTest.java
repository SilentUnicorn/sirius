package think.in.java;

/**
 * @author zhangjingsi
 * @date 2019/3/13上午9:34
 */
public class YieldTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i ++){
                System.out.println(Thread.currentThread().getName() + "("+Thread.currentThread().getPriority()+"):" + i);
                if (i == 30){
                    Thread.yield();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50; i ++){
                System.out.println(Thread.currentThread().getName() + "("+Thread.currentThread().getPriority()+"):" + i);
                if (i == 30){
                    Thread.yield();
                }
            }
        });
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
    }
}
