package com.susan.demo.transaction;

import com.susan.demo.spring.ioc.aware.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 在使用spring事务时，有个让人非常头疼的问题，就是大事务问题。
 * <p>
 * 通常情况下，我们会在方法上@Transactional注解，填加事务功能
 * <p>
 * 但@Transactional注解，如果被加到方法上，有个缺点就是整个方法都包含在事务当中了。
 * <p>
 * 上面的这个例子中，在UserService类中，其实只有这两行才需要事务：
 * <p>
 * roleService.save(userModel);
 * update(userModel);
 * <p>
 * 现在的这种写法，会导致所有的query方法也被包含在同一个事务当中。
 * <p>
 * 如果query方法非常多，调用层级很深，而且有部分查询方法比较耗时的话，会造成整个事务非常耗时，而从造成大事务问题。
 *
 * @author sue
 * @date 2023/2/18 10:36
 */
public class BigTransactionService {


    @Autowired
    private BigTransactionOtherService bigTransactionOtherService;

    @Transactional
    public void add(UserModel userModel) throws Exception {
        query1();
        query2();
        query3();
        bigTransactionOtherService.save(userModel);
        update(userModel);
    }

    private void query1() {

    }

    private void query2() {

    }

    private void query3() {

    }

    private void update(UserModel userModel) {

    }
}

@Service
class BigTransactionOtherService {

    @Transactional
    public void save(UserModel userModel) throws Exception {
        query4();
        query5();
        query6();
        saveData(userModel);
    }

    private void query4() {

    }

    private void query5() {

    }

    private void query6() {

    }

    private void saveData(UserModel userModel) {

    }
}
