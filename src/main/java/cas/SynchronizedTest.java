package cas;

/**
 * @author zhangjingsi
 * @date 2018/11/28上午11:53
 * synchronized 会锁定读取资源(printFlag)，所以只有前一个线程释放之后才能锁之后，下一个线程才可操作
 */
public class SynchronizedTest implements Runnable{

    public synchronized static void printFlag() {
        System.out.println(flag);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Boolean flag = new Boolean(true);

    public static void main(String[] args) {
        SynchronizedTest s = new SynchronizedTest();
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        SynchronizedTest.printFlag();
    }
}
