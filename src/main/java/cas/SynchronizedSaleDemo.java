package cas;

/**
 * @author zhangjingsi
 * @date 2018/11/28下午2:14
 * 卖票的简单模拟
 */
public class SynchronizedSaleDemo implements Runnable{
    private static int tickets = 50;

    public static void main(String[] args) {
        /**10个窗口买票*/
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SynchronizedSaleDemo());
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result: " + tickets);
    }

    @Override
    public void run() {
        while (tickets > 0){
            try {
                /**此处sleep 5 毫秒，模拟一系列的复杂逻辑，这就导致获取资源和更新资源成了非原子操作，虽然获取的时候count是大于0的
                 * 但是更新的时候已经有了其他线程对资源进行了操作，此时 count就不一定大于0了*/
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tickets--;
        }
    }

    /**这里通过 synchronized 将获取和更新封装成原子操作，就不会再出现票的余数为负的情况*/
    public synchronized static void sale(){
        if (tickets > 0){
            tickets--;
        }
    }
}
