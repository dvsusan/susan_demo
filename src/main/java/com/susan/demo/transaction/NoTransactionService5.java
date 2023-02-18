package com.susan.demo.transaction;

import com.susan.demo.spring.ioc.aware.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 我们可以看到事务方法add中，调用了事务方法doOtherThing，
 * 但是事务方法doOtherThing是在另外一个线程中调用的。
 * <p>
 * 这样会导致两个方法不在同一个线程中，获取到的数据库连接不一样，从而是两个不同的事务。
 * 如果想doOtherThing方法中抛了异常，add方法也回滚是不可能的。
 * <p>
 * 如果看过spring事务源码的朋友，可能会知道spring的事务是通过数据库连接来实现的。
 * 当前线程中保存了一个map，key是数据源，value是数据库连接。
 * <p>
 * 我们说的同一个事务，其实是指同一个数据库连接，只有拥有同一个数据库连接才能同时提交和回滚。
 * 如果在不同的线程，拿到的数据库连接肯定是不一样的，所以是不同的事务。
 *
 * @author sue
 * @date 2023/2/18 10:26
 */
@Service
public class NoTransactionService5 {

    @Autowired
    private RoleService roleService;

    @Transactional
    public void add(UserModel userModel) throws Exception {
        insertUser(userModel);
        new Thread(() -> {
            roleService.doOtherThing();
        }).start();
    }

    private void insertUser(UserModel userModel) {

    }
}


@Service
class RoleService {

    @Transactional
    public void doOtherThing() {
        System.out.println("保存role表数据");
    }
}