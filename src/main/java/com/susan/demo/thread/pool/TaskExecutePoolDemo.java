package com.susan.demo.thread.pool;

import com.susan.demo.thread.config.TaskThreadPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建自定义线程池 demo
 */
@Configuration
public class TaskExecutePoolDemo {

    @Autowired
    TaskThreadPoolConfig config;

    @Bean("poolDemo")
    public Executor poolDemo() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 配置相关参数

        // 核心线程池大小
        executor.setCorePoolSize(config.getCorePoolSize());
        // 最大线程数
        executor.setMaxPoolSize(config.getMaxPoolSize());
        // 队列容量
        executor.setQueueCapacity(config.getQueueCapacity());
        // 活跃时间
        executor.setKeepAliveSeconds(config.getKeepAliveSeconds());
        // 线程名字前缀
        executor.setThreadNamePrefix("DemoExecutor-");

        /*
          设置拒绝策略：当线程池的任务缓存队列已满并且线程池中的线程数目达到 maximumPoolSize 时，如果还有任务到来就会采取任务拒绝策略
          四种拒绝策略简介：
          ThreadPoolExecutor.AbortPolicy（线程池默认的拒绝策略）:丢弃任务并抛出 RejectedExecutionException 异常
          ThreadPoolExecutor.DiscardPolicy：丢弃任务，但是不抛出异常
          ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新提交被拒绝的任务
          ThreadPoolExecutor.CallerRunsPolicy：不在新线程中执行任务，由调用线程（提交任务的线程）处理该任务
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
