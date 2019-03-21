package think.in.java;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangjingsi
 * @date 2019/3/13上午11:10
 */
@Slf4j
public class LogTest {

    public static void main(String[] args) throws InterruptedException {
        for(int i =0; i < 100; i++){
            log.debug("log");
            log.info("log");
            log.warn("log");
            log.error("log");
            Thread.sleep(100L);
        }
    }
}
