package com.susan.demo.util;

import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.util.SerializationUtils;

import java.util.Map;

/**
 * 主要介绍SerializationUtils类的常用方法
 *
 * @author sue
 * @date 2023/2/17 23:28
 */
public class SerializationUtilsTest {

    /**
     * 有时候，我们需要把数据进行序列化和反序列化处理。
     * <p>
     * 传统的做法是某个类实现Serializable接口，然后重新它的writeObject和readObject方法。
     * <p>
     * 但如果使用org.springframework.util包下的SerializationUtils工具类，
     * 能更轻松实现序列化和反序列化功能
     */
    @Test
    public void testSerializeAndDeserialize() {
        Map<String, String> map = Maps.newHashMap();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        byte[] serialize = SerializationUtils.serialize(map);
        Object deserialize = SerializationUtils.deserialize(serialize);
        System.out.println(deserialize);
    }
}
