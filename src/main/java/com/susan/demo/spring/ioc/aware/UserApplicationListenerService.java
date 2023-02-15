package com.susan.demo.spring.ioc.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * 实现ApplicationListener接口，
 * 需要注意的是该接口接收的泛型是ContextRefreshedEvent类，
 * 然后重写onApplicationEvent方法，
 * 也能从该方法中获取到Spring容器对象。
 *
 * @author sue
 * @date 2023/2/15 20:41
 */
@Service
public class UserApplicationListenerService implements ApplicationListener<ContextRefreshedEvent> {
    private ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        applicationContext = event.getApplicationContext();
    }

    public void add() {
        UserModel userModel = (UserModel) applicationContext.getBean("userModel");
    }

}