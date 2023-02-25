package com.susan.demo.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 有时候我们需要在项目启动时定制化一些附加功能，比如：加载一些系统参数、完成初始化、预热本地缓存等，该怎么办呢？
 * <p>
 * 好消息是springboot提供了：
 * <p>
 * CommandLineRunner
 * ApplicationRunner
 * 这两个接口帮助我们实现以上需求。
 * <p>
 * 它们的用法还是挺简单的，以ApplicationRunner接口为例：
 * <p>
 * 实现ApplicationRunner接口，重写run方法，在该方法中实现自己定制化需求。
 * <p>
 * 如果项目中有多个类实现了ApplicationRunner接口，他们的执行顺序要怎么指定呢？
 * <p>
 * 答案是使用@Order(n)注解，n的值越小越先执行。当然也可以通过@Priority注解指定顺序。
 *
 * @author sue
 * @date 2023/2/25 23:18
 */
@Component
public class TestApplicationRunner implements ApplicationRunner {

    @Autowired
    private LoadDataService loadDataService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadDataService.load();
    }
}
