package com.susan.demo.util;

import org.junit.jupiter.api.Test;
import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;

/**
 * 主要介绍Base64Utils类的常用方法
 *
 * @author sue
 * @date 2023/2/17 23:24
 */
public class Base64UtilsTest {

    /**
     * 有时候，为了安全考虑，需要将参数只用base64编码。
     * <p>
     * 这时就能直接使用org.springframework.util包下的Base64Utils工具类。
     * <p>
     * 它里面包含：encode和decode方法，用于对数据进行加密和解密
     */
    @Test
    public void testEncodeAndDecode() {
        String str = "abc";
        String encode = new String(Base64Utils.encode(str.getBytes()));
        System.out.println("加密后：" + encode);
        try {
            String decode = new String(Base64Utils.decode(encode.getBytes()), "utf8");
            System.out.println("解密后：" + decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
