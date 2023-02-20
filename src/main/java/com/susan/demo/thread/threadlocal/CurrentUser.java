package com.susan.demo.thread.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.Data;

/**
 * 获取当前用户实体
 *
 * @author sue
 * @date 2023/2/17 23:58
 */
@Data
public class CurrentUser {

    private static final TransmittableThreadLocal<CurrentUser> USER_THREAD_LOCAL = new TransmittableThreadLocal<>();

    private String id;
    private String userName;
    private String password;
    private String phone;

    public static void set(CurrentUser user) {
        USER_THREAD_LOCAL.set(user);
    }

    public static CurrentUser getCurrent() {
        return USER_THREAD_LOCAL.get();
    }
}
