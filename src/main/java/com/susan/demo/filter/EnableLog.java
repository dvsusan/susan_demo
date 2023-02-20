package com.susan.demo.filter;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义开关@EnableLog注解
 * <p>
 * 后面只需在springboot启动类加上@EnableLog注解，
 * 即可开启LogFilter记录请求和响应日志的功能。
 *
 * @author sue
 * @date 2023/2/15 21:15
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(LogFilterWebConfig.class)
public @interface EnableLog {

}
