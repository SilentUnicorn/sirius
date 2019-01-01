package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhangjingsi
 * @date 2018/12/26下午6:40
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        SpringBeanTest bean = context.getBean(SpringBeanTest.class);
        System.out.println(bean.getName());
    }
}
