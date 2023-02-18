package com.susan.demo.transaction;

import com.susan.demo.spring.ioc.aware.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * spring还提供了另外一种创建事务的方式，即通过手动编写代码实现的事务，
 * 我们把这种事务叫做：编程式事务
 * <p>
 * 在spring中为了支持编程式事务，专门提供了一个类：TransactionTemplate，在它的execute方法中，就实现了事务的功能。
 * <p>
 * 相较于@Transactional注解声明式事务，我更建议大家使用，基于TransactionTemplate的编程式事务。主要原因如下：
 * <p>
 * 避免由于spring aop问题，导致事务失效的问题。
 * 能够更小粒度的控制事务的范围，更直观。
 *
 * @author sue
 * @date 2023/2/18 10:40
 */
public class TransactionTemplateService {

    @Autowired
    private TransactionTemplate transactionTemplate;

    public void add(UserModel userModel) throws Exception {
        queryData1();
        queryData2();
        transactionTemplate.execute((status) -> {
            addData();
            updateData();
            return Boolean.TRUE;
        });
    }

    private void queryData1() {

    }

    private void queryData2() {

    }

    private void addData() {
    }

    private void updateData() {

    }

}
