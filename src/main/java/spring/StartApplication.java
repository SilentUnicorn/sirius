package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhangjingsi
 * @date 2018/12/26下午6:54
 */
public class StartApplication {
    public static void main(String[] args) {
        System.out.println("初始化容器...");
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        SpringBeanTest bean = context.getBeanFactory().getBean(SpringBeanTest.class);
        System.out.println(bean.toString());
        System.out.println("销毁容器");
        context.registerShutdownHook();
        System.exit(0);
    }
}
