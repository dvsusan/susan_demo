package com.susan.demo.spring.ioc.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

/**
 * 实现BeanFactoryAware接口，
 * 然后重写setBeanFactory方法，
 * 就能从该方法中获取到Spring容器对象。
 *
 * @author sue
 * @date 2023/2/15 20:37
 */
@Service
public class UserBeanFactoryAwareService implements BeanFactoryAware {
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void add() {
        UserModel userModel = (UserModel) beanFactory.getBean("userModel");
    }
}