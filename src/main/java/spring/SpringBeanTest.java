package spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zhangjingsi
 * @date 2018/12/26下午6:21
 */
@Component
public class SpringBeanTest implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean{

    private String name;
    private String address;
    private Integer phone;

    public SpringBeanTest() {
        System.out.println("constructor");
    }

    public String getName() {
        return name;
    }

    public SpringBeanTest setName(String name) {
        System.out.println("setName");
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SpringBeanTest setAddress(String address) {
        System.out.println("setAddress");
        this.address = address;
        return this;
    }

    public Integer getPhone() {
        return phone;
    }

    public SpringBeanTest setPhone(Integer phone) {
        System.out.println("setPhone");
        this.phone = phone;
        return this;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName:" + s);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @PostConstruct
    public void myInit(){
        System.out.println("init-method");
        this.setName("张三");
        this.setAddress("北京");
        this.setPhone(1234567890);
    }

    @PreDestroy
    public void myDestory(){
        System.out.println("destory-method");
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SpringBeanTest{");
        sb.append("name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", phone=").append(phone);
        sb.append('}');
        return sb.toString();
    }
}
