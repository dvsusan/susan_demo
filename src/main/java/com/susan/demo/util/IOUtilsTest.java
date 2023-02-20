package com.susan.demo.util;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 主要介绍IOUtils类的常用方法
 *
 * @author sue
 * @date 2023/2/17 23:08
 */
public class IOUtilsTest {

    /**
     * 如果你想将某个txt文件中的数据，读取到字符串当中，
     * 可以使用IOUtils类的toString方法
     */
    @Test
    public void testReadFile() throws IOException {
        String str = IOUtils.toString(new FileInputStream("/temp/a.txt"), StandardCharsets.UTF_8);
        System.out.println(str);
    }

    /**
     * 如果你想将某个字符串的内容，写入到指定文件当中，可以使用IOUtils类的write方法
     *
     * @throws IOException 异常
     */
    @Test
    public void testWriteFile() throws IOException {
        String str = "abcde";
        IOUtils.write(str, new FileOutputStream("/temp/b.tx"), StandardCharsets.UTF_8);
    }

    /**
     * 如果你想将某个文件中的所有内容，都拷贝到另一个文件当中，
     * 可以使用IOUtils类的copy方法
     *
     * @throws IOException
     */
    @Test
    public void testCopy() throws IOException {
        IOUtils.copy(new FileInputStream("/temp/a.txt"), new FileOutputStream("/temp/b.txt"));
    }

    /**
     * 如果你想将某个文件中的内容，读取字节数组中，
     * 可以使用IOUtils类的toByteArray方法
     *
     * @throws IOException 异常
     */
    @Test
    public void testToByteArray() throws IOException {
        byte[] bytes = IOUtils.toByteArray(new FileInputStream("/temp/a.txt"));
    }
}
