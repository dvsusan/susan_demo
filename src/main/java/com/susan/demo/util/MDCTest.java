package com.susan.demo.util;

import org.slf4j.MDC;

/**
 * 主要介绍MDC工具的常用方法
 *
 * @author sue
 * @date 2023/2/17 23:12
 */
public class MDCTest {

    private static final String TRACE_ID = "TRACE_ID";

    public static String get() {
        return MDC.get(TRACE_ID);
    }

    public static void add(String value) {
        MDC.put(TRACE_ID, value);
    }
}
