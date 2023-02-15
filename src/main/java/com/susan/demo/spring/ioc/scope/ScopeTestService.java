package com.susan.demo.spring.ioc.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 测试自定义的scope
 *
 * @author sue
 * @date 2023/2/15 20:56
 */
@Scope("threadLocalScope")
@Service
public class ScopeTestService {

    public void add() {
    }
}
