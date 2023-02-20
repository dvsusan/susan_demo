package com.susan.demo.spring.ioc.convertor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户实体
 *
 * @author sue
 * @date 2023/2/14 21:54
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 注册时间
     */
    private Date registerDate;
}
