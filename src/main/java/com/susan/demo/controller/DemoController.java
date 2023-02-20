package com.susan.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo controller
 *
 * @author sue
 * @date 2023/2/14 21:55
 */
@RestController
@RequestMapping("")
public class DemoController {

    /**
     * demo接口
     *
     * @return 欢迎语
     */
    @GetMapping("/demo")
    public String demo() {
        return "欢迎访问susan demo的世界";
    }
}
