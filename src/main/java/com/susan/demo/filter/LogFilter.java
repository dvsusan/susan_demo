package com.susan.demo.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 不知道你有没有用过Enable开头的注解，比如：EnableAsync、EnableCaching、EnableAspectJAutoProxy等，
 * 这类注解就像开关一样，只要在@Configuration定义的配置类上加上这类注解，就能开启相关的功能。
 * <p>
 * 是不是很酷？
 * <p>
 * 让我们一起实现一个自己的开关：
 * <p>
 * 第一步，定义一个LogFilter
 *
 * @author sue
 * @date 2023/2/15 21:13
 */
@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("记录请求日志");
        chain.doFilter(request, response);
        log.info("记录响应日志");
    }

    @Override
    public void destroy() {

    }
}