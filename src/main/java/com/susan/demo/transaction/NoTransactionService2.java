package com.susan.demo.transaction;

import com.susan.demo.spring.ioc.aware.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 有时候，某个方法不想被子类重新，这时可以将该方法定义成final的。
 * 普通方法这样定义是没问题的，但如果将事务方法定义成final
 * <p>
 * 我们可以看到add方法被定义成了final的，这样会导致事务失效。
 * <p>
 * 为什么？
 * <p>
 * 如果你看过spring事务的源码，可能会知道spring事务底层使用了aop，
 * 也就是通过jdk动态代理或者cglib，帮我们生成了代理类，在代理类中实现的事务功能。
 * <p>
 * 但如果某个方法用final修饰了，那么在它的代理类中，就无法重写该方法，而添加事务功能。
 *
 * @author sue
 * @date 2023/2/18 10:22
 */
@Service
public class NoTransactionService2 {

    @Transactional
    public final void add(UserModel userModel) {
        saveData(userModel);
        updateData(userModel);
    }

    private void saveData(UserModel userModel) {
    }

    private void updateData(UserModel userModel) {
    }
}
