package com.susan.demo.spring.aop.interceptor;

import org.slf4j.MDC;

/**
 * mdc工具
 * MdcUtil其实是利用MDC工具在ThreadLocal中存储和获取traceId
 *
 * @author sue
 * @date 2023/2/16 20:38
 */
public class MdcUtil {

    private static final String TRACE_ID = "TRACE_ID";

    public static String get() {
        return MDC.get(TRACE_ID);
    }

    public static void add(String value) {
        MDC.put(TRACE_ID, value);
    }
}
