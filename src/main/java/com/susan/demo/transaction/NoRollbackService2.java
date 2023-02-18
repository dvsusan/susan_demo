package com.susan.demo.transaction;

import com.susan.demo.spring.ioc.aware.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务不会回滚，最常见的问题是：开发者在代码中手动try...catch了异常
 * <p>
 * 这种情况下spring事务当然不会回滚，因为开发者自己捕获了异常，又没有手动抛出，换句话说就是把异常吞掉了。
 * <p>
 * 如果想要spring事务能够正常回滚，必须抛出它能够处理的异常。如果没有抛异常，则spring认为程序是正常的。
 *
 * @author sue
 * @date 2023/2/18 10:29
 */
@Slf4j
@Service
public class NoRollbackService2 {

    @Transactional
    public void add(UserModel userModel) {
        try {
            saveData(userModel);
            updateData(userModel);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private void saveData(UserModel userModel) {
    }

    private void updateData(UserModel userModel) {
    }
}
