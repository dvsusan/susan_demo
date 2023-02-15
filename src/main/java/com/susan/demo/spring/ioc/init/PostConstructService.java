package com.susan.demo.spring.ioc.init;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 在需要初始化的方法上增加@PostConstruct注解，这样就有初始化的能力
 *
 * @author sue
 * @date 2023/2/15 20:49
 */
@Service
public class PostConstructService {

    @PostConstruct
    public void init() {
        System.out.println("===PostConstruct===");
    }
}