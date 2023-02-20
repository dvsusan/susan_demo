package com.susan.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试异常接口
 *
 * @author sue
 * @date 2023/2/20 19:48
 */
@RequestMapping("/exception")
@RestController
public class ExceptionController {

    /**
     * 测试方法
     */
    @GetMapping("/test")
    public String test() {
        int a = 10 / 0;
        return "成功";
    }
}
