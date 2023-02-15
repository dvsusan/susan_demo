package com.susan.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
