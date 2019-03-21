package the.art.of.java.concurrency.programming;

/**
 * @author zhangjingsi
 * @date 2019/3/7上午10:36
 */
public class SyncTest {
    private int flag;
    public void write(){
        flag++;
        System.out.println(Thread.currentThread().getName() + ":write end.");
    }
    public void read(){
        System.out.println(flag);
        System.out.println(Thread.currentThread().getName() + ":read end.");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        SyncTest s = new SyncTest();
        Thread t1 = new Thread(() -> {
            s.write();
        });
        Thread t2 = new Thread(() ->{
            s.read();
        });

        t2.start();
        Thread.sleep(100L);
        t1.start();
    }
}
