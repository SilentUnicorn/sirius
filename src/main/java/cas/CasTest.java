package cas;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author zhangjingsi
 * @date 2018/11/28上午11:02
 * synchronized 基于悲观锁思想，悲观的认为每次操作都会产生线程安全问题，所以每次拿到资源之后都会加锁，其他需要访问此资源的线程都必须挂起等待
 * 虽然保证了线程安全但是降低了一定的效率
 * cas 基于乐观锁思想，乐观的认为所有操作都不会产生线程安全问题，所以任何操作都不会加锁，但是更新之前都要判断其他线程有没有修改资源，如果修改了，
 * 产生了冲突就重试，直到成功为止。
 */
public class CasTest implements Runnable{
    private static AtomicBoolean flag = new AtomicBoolean();

    public static void main(String[] args) {
        System.out.println(flag.get());
        CasTest casTest = new CasTest();
        Thread t1 = new Thread(casTest);
        Thread t2 = new Thread(casTest);
        t1.start();
        t2.start();
    }
    @Override
    public void run() {
        int count = 0;
        while(true){
            count++;
            System.out.println(Thread.currentThread().getName() + "-count:" + count);
            /**这里在前一个线程操作完成之前，后一个线程会发现并发冲突，然后返回false，我们设置的机制就是更新失败则重试，直到成功*/
            if (flag.compareAndSet(false, true)){
                System.out.println(Thread.currentThread().getName() + "-" + flag);
                try {
                    Thread.sleep(2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag.set(false);
                break;
            }
        }
    }
}
