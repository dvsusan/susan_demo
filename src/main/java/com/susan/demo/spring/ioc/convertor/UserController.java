package com.susan.demo.spring.ioc.convertor;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试时间转换的接口
 *
 * @author sue
 * @date 2023/2/15 21:04
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @RequestMapping("/save")
    public String save(@RequestBody UserModel user) {
        return "success";
    }
}
