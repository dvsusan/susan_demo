package com.susan.demo.spring.ioc.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * 实现InitializingBean接口，
 * 重写afterPropertiesSet方法，
 * 该方法中可以完成初始化功能。
 *
 * 这里顺便抛出一个有趣的问题：init-method（xml文件中配置）、PostConstruct 和 InitializingBean 的执行顺序是什么样的？
 *
 * 初始化方法的调用顺序：PostConstruct 》InitializingBean 》init-method
 * @author sue
 * @date 2023/2/15 20:50
 */
@Service
public class InitializingBeanService implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("===InitializingBean===");
    }
}