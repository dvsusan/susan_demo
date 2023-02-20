package com.susan.demo.spring.ioc.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;


/**
 * 实现ApplicationContextAware接口，
 * 然后重写setApplicationContext方法，
 * 也能从该方法中获取到Spring容器对象。
 *
 * @author sue
 * @date 2023/2/15 20:40
 */
@Service
public class UserApplicationContextAwareService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void add() {
        UserModel userModel = (UserModel) applicationContext.getBean("userModel");
    }
}
