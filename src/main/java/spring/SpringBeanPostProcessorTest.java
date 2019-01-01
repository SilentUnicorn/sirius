package spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author zhangjingsi
 * @date 2018/12/26下午6:44
 */
@Component
public class SpringBeanPostProcessorTest implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SpringBeanTest){
            System.out.println("start init SpringBeanTest...");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SpringBeanTest){
            System.out.println("init SpringBeanTest end.");
        }
        return bean;
    }
}
