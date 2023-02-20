package com.susan.demo.spring.ioc.factorybean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

/**
 * getBean("myFactoryBean");获取的是MyFactoryBeanService类中getObject方法返回的对象，
 * <p>
 * getBean("&myFactoryBean");获取的才是MyFactoryBean对象。
 *
 * @author sue
 * @date 2023/2/15 20:59
 */
@Service
public class MyFactoryBeanService implements BeanFactoryAware {
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void test() {
        Object myFactoryBean = beanFactory.getBean("myFactoryBean");
        System.out.println(myFactoryBean);
        Object myFactoryBean1 = beanFactory.getBean("&myFactoryBean");
        System.out.println(myFactoryBean1);
    }
}