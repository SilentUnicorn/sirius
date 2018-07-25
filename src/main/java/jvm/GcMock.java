package jvm;

/**
 * @author zhangjingsi
 * @date 2018/4/24下午2:48
 */
public class GcMock {
    private static GcMock save = null;
    public static void main(String[] args) throws InterruptedException {
        save = new GcMock();
        save = null;
        System.gc();
        Thread.sleep(500);
        if (save != null){
            save.isAlive();
        }else{
            System.out.println("I am dead!");
        }
    }

    public void isAlive(){
        System.out.println("I am alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        save = this;
    }
}
