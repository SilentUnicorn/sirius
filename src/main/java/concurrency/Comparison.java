package concurrency;

/**
 * @author zhangjingsi
 * @date 2018/7/23上午9:33
 *
 * 对比结果 /ms
 *              concurrency     serial
 *  1万          67                 0
 *  10万         66                 3
 *  100万        67                 11
 *  1亿          144                85
 *  10亿         639                928
 *  可以看出count数值比较小的时候，线程切换的开销占比比较高(100万以内，线程切换占用90%以上的时间)，多线程反而降低了运算速度
 *  当数值增加到10亿的时候，运算所占时间逐渐变大，线程切换时间占比较小，多线程的效率比较高
 */
public class Comparison {
    private static final long count =100000000L;

    public static void main(String[] args) throws InterruptedException {
        Comparison.concurrency();
        Comparison.serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            int a = 0;
            for(long i = 0; i < count; i ++){
                a += 5;
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency:"+time+"ms,b="+b);
    }
    private static void serial(){
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++){
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:"+time+"ms,b="+b+",a:"+a);
    }
}
