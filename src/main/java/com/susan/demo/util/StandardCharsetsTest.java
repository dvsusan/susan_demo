package com.susan.demo.util;

import org.junit.jupiter.api.Test;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;

/**
 * 主要介绍StandardCharsets类下的常用参数
 *
 * @author sue
 * @date 2023/2/17 23:26
 */
public class StandardCharsetsTest {

    /**
     * 我们在做字符转换的时候，经常需要指定字符编码，比如：UTF-8、ISO-8859-1等等。
     * <p>
     * 这时就可以直接使用java.nio.charset包下的StandardCharsets类中静态变量
     */
    @Test
    public void testCharset() {
        String str = "abc";
        String encode = new String(Base64Utils.encode(str.getBytes()));
        System.out.println("加密后：" + encode);
        String decode = new String(Base64Utils.decode(encode.getBytes())
                , StandardCharsets.UTF_8);
        System.out.println("解密后：" + decode);
    }
}
