package com.susan.demo.transaction;

import com.susan.demo.spring.ioc.aware.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 众所周知，java的访问权限主要有四种：private、default、protected、public，
 * 它们的权限从左到右，依次变大。
 * <p>
 * 但如果我们在开发过程中，把有某些事务方法，定义了错误的访问权限，就会导致事务功能出问题
 * <p>
 * 我们可以看到add方法的访问权限被定义成了private，这样会导致事务失效，
 * spring要求被代理方法必须是public的。
 *
 * @author sue
 * @date 2023/2/18 10:20
 */
@Service
public class NoTransactionService1 {

    @Transactional
    private void add(UserModel userModel) {
        saveData(userModel);
        updateData(userModel);
    }

    private void saveData(UserModel userModel) {
    }

    private void updateData(UserModel userModel) {
    }

}
