package com.susan.demo.transaction;

import com.susan.demo.spring.ioc.aware.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 在我们平时开发过程中，有个细节很容易被忽略。
 * 即使用spring事务的前提是：对象要被spring管理，需要创建bean实例。
 * <p>
 * 通常情况下，我们通过@Controller、@Service、@Component、@Repository等注解，
 * 可以自动实现bean实例化和依赖注入的功能。
 * <p>
 * 我们可以看到UserService类没有加@Service注解，
 * 那么该类不会交给spring管理，所以它的add方法也不会生成事务。
 *
 * @author sue
 * @date 2023/2/18 10:25
 */
//@Service
public class NoTransactionService4 {

    @Transactional
    public void add(UserModel userModel) {
    }
}
