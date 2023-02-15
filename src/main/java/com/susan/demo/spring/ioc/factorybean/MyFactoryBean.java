package com.susan.demo.spring.ioc.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 说起FactoryBean就不得不提BeanFactory，因为面试官老喜欢问它们的区别。
 * <p>
 * BeanFactory：spring容器的顶级接口，管理bean的工厂。
 * FactoryBean：并非普通的工厂bean，它隐藏了实例化一些复杂Bean的细节，给上层应用带来了便利。
 * mybatis的SqlSessionFactory对象就是通过SqlSessionFactoryBean类创建的。
 *
 * @author sue
 * @date 2023/2/15 20:58
 */
@Component
public class MyFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        String data1 = buildData1();
        String data2 = buildData2();
        return buildData3(data1, data2);
    }

    private String buildData1() {
        return "data1";
    }

    private String buildData2() {
        return "data2";
    }

    private String buildData3(String data1, String data2) {
        return data1 + data2;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}