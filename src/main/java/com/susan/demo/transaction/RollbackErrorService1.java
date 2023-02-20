package com.susan.demo.transaction;

import com.susan.demo.spring.ioc.aware.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 这种情况使用了嵌套的内部事务，原本是希望调用roleService.doOtherThing方法时，
 * 如果出现了异常，只回滚doOtherThing方法里的内容，不回滚 userMapper.insertUser里的内容，即回滚保存点。。
 * 但事实是，insertUser也回滚了。
 * <p>
 * why?
 * <p>
 * 因为doOtherThing方法出现了异常，没有手动捕获，会继续往上抛，到外层add方法的代理方法中捕获了异常。
 * 所以，这种情况是直接回滚了整个事务，不只回滚单个保存点。
 * <p>
 * 可以将内部嵌套事务放在try/catch中，并且不继续往上抛异常。
 * 这样就能保证，如果内部嵌套事务中出现异常，只回滚内部事务，而不影响外部事务。
 *
 * @author sue
 * @date 2023/2/18 10:33
 */
@Service
public class RollbackErrorService1 {

    @Autowired
    private RollbackService roleService;

    @Transactional
    public void add(UserModel userModel) throws Exception {
        insertUser(userModel);
        roleService.doOtherThing();
    }

    private void insertUser(UserModel userModel) {
    }

}

@Service
class RollbackService {

    @Transactional(propagation = Propagation.NESTED)
    public void doOtherThing() {
        System.out.println("保存role表数据");
    }
}
