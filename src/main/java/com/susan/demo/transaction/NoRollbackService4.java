package com.susan.demo.transaction;

import com.susan.demo.spring.ioc.aware.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 在使用@Transactional注解声明事务时，有时我们想自定义回滚的异常，spring也是支持的。
 * 可以通过设置rollbackFor参数，来完成这个功能。
 * <p>
 * 但如果这个参数的值设置错了，就会引出一些莫名其妙的问题
 * <p>
 * 如果在执行上面这段代码，保存和更新数据时，程序报错了，抛了SqlException、DuplicateKeyException等异常。
 * 而BusinessException是我们自定义的异常，报错的异常不属于BusinessException，所以事务也不会回滚。
 * <p>
 * 即使rollbackFor有默认值，但阿里巴巴开发者规范中，还是要求开发者重新指定该参数。
 * <p>
 * 这是为什么呢？
 * <p>
 * 因为如果使用默认值，一旦程序抛出了Exception，事务不会回滚，这会出现很大的bug。所以，建议一般情况下，将该参数设置成：Exception或Throwable。
 *
 * @author sue
 * @date 2023/2/18 10:30
 */
@Slf4j
@Service
public class NoRollbackService4 {

    @Transactional(rollbackFor = BusinessException.class)
    public void add(UserModel userModel) throws Exception {
        saveData(userModel);
        updateData(userModel);
    }

    private void saveData(UserModel userModel) {
    }

    private void updateData(UserModel userModel) {
    }
}

class BusinessException extends RuntimeException {

}