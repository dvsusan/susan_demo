package com.susan.demo.transaction;

import com.susan.demo.spring.ioc.aware.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 即使开发者没有手动捕获异常，但如果抛的异常不正确，spring事务也不会回滚
 * <p>
 * 上面的这种情况，开发人员自己捕获了异常，又手动抛出了异常：Exception，事务同样不会回滚。
 * <p>
 * 因为spring事务，默认情况下只会回滚RuntimeException（运行时异常）和Error（错误），
 * 对于普通的Exception（非运行时异常），它不会回滚。
 *
 * @author sue
 * @date 2023/2/18 10:30
 */
@Slf4j
@Service
public class NoRollbackService3 {

    @Transactional
    public void add(UserModel userModel) throws Exception {
        try {
            saveData(userModel);
            updateData(userModel);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new Exception(e);
        }
    }

    private void saveData(UserModel userModel) {
    }

    private void updateData(UserModel userModel) {
    }
}
