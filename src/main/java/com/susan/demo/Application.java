package com.susan.demo;

import com.susan.demo.filter.EnableLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 服务启动程序
 */
@EnableLog
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {


    /**
     * 程序入口
     *
     * @param args 程序输入参数
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
