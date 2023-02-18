package com.susan.demo.transaction;

import com.susan.demo.spring.ioc.aware.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 有时候我们需要在某个Service类的某个方法中，调用另外一个事务方法
 * <p>
 * 我们看到在事务方法add中，直接调用事务方法updateStatus。
 * 从前面介绍的内容可以知道，updateStatus方法拥有事务的能力是因为spring aop生成代理了对象，
 * 但是这种方法直接调用了this对象的方法，所以updateStatus方法不会生成事务。
 * <p>
 * 由此可见，在同一个类中的方法直接内部调用，会导致事务失效。
 *
 * @author sue
 * @date 2023/2/18 10:23
 */
@Service
public class NoTransactionService3 {


    public final void add(UserModel userModel) {
        saveData(userModel);
    }

    @Transactional
    public void saveData(UserModel userModel) {
    }
}
