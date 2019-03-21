package the.art.of.java.concurrency.programming;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangjingsi
 * @date 2019/3/15上午10:19
 */
@Slf4j
public class CountDownLatchTest {
    private static CountDownLatch parallelStart = new CountDownLatch(1);
    private static CountDownLatch mainWaitEnd = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(CountDownLatchTest::run, "t1");
        Thread t2 = new Thread(CountDownLatchTest::run, "t2");
        Thread t3 = new Thread(CountDownLatchTest::run, "t3");
        t1.start();
        t2.start();
        t3.start();
        log.info("sub thread start");
        parallelStart.countDown();
        mainWaitEnd.await();
        log.info("sub thread end");
    }

    private static void run() {
        log.info(Thread.currentThread().getName() + "等待 main 线程通知并发执行");
        try {
            parallelStart.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName() + "running...");
        mainWaitEnd.countDown();
    }
}
