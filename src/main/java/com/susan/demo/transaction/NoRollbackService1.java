package com.susan.demo.transaction;

import com.susan.demo.spring.ioc.aware.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 们在使用@Transactional注解时，是可以指定propagation参数的。
 * <p>
 * 该参数的作用是指定事务的传播特性，spring目前支持7种传播特性：
 * <p>
 * REQUIRED 如果当前上下文中存在事务，那么加入该事务，如果不存在事务，创建一个事务，这是默认的传播属性值。
 * SUPPORTS 如果当前上下文存在事务，则支持事务加入事务，如果不存在事务，则使用非事务的方式执行。
 * MANDATORY 如果当前上下文中存在事务，否则抛出异常。
 * REQUIRES_NEW 每次都会新建一个事务，并且同时将上下文中的事务挂起，执行当前新建事务完成以后，上下文事务恢复再执行。
 * NOT_SUPPORTED 如果当前上下文中存在事务，则挂起当前事务，然后新的方法在没有事务的环境中执行。
 * NEVER 如果当前上下文中存在事务，则抛出异常，否则在无事务环境上执行代码。
 * NESTED 如果当前上下文中存在事务，则嵌套事务执行，如果不存在事务，则新建事务。
 * 如果我们在手动设置propagation参数的时候，把传播特性设置错了
 * <p>
 * 我们可以看到add方法的事务传播特性定义成了Propagation.NEVER，这种类型的传播特性不支持事务，如果有事务则会抛异常。
 * <p>
 * 目前只有这三种传播特性才会创建新事务：REQUIRED，REQUIRES_NEW，NESTED。
 *
 * @author sue
 * @date 2023/2/18 10:28
 */
@Service
public class NoRollbackService1 {

    @Transactional(propagation = Propagation.NEVER)
    public void add(UserModel userModel) {
        saveData(userModel);
        updateData(userModel);
    }

    private void saveData(UserModel userModel) {
    }

    private void updateData(UserModel userModel) {
    }
}
