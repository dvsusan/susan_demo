package com.susan.demo.thread.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 线程池配置属性类
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "susan.demo.task.pool")
public class TaskThreadPoolConfig {

    /**
     * 核心线程池大小
     */
    private int corePoolSize;

    /**
     * 最大线程数
     */
    private int maxPoolSize;

    /**
     * 线程活跃时间
     */
    private int keepAliveSeconds;

    /**
     * 队列容量
     */
    private int queueCapacity;
}
