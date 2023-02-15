package com.susan.demo.filter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;

/**
 * 第二步，注册LogFilter到Spring容器中
 *
 * @author sue
 * @date 2023/2/15 21:14
 */
@ConditionalOnWebApplication
public class LogFilterWebConfig {

    @Bean
    public LogFilter timeFilter() {
        return new LogFilter();
    }
}