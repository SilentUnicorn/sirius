package cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangjingsi
 * @date 2018/11/28下午3:12
 */
public class CasSaleDemo implements Runnable{
    private static AtomicInteger tickets = new AtomicInteger(50);

    public static void main(String[] args) {
        /**10个窗口买票*/
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new CasSaleDemo());
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
        while (true){
            int current = tickets.get();
            if (current <= 0){
                break;
            }
            System.out.println("---已下单");
            int next = current - 1;
            try {
                /**模拟复杂业务逻辑操作*/
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = tickets.compareAndSet(current, next);
            if (result){
                System.out.println("---出票成功");
            }else{
                System.out.println("---出票失败");
            }
        }

    }
}
