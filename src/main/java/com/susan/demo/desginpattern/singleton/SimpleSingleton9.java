package com.susan.demo.desginpattern.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * ava中的类通过实现Serializable接口，可以实现序列化。
 * <p>
 * 我们可以把类的对象先保存到内存，或者某个文件当中。后面在某个时刻，再恢复成原始对象。
 * <p>
 * 说明，反序列化时创建了一个新对象，打破了单例模式对象唯一性的要求。
 * <p>
 * 那么，如何解决这个问题呢？
 * <p>
 * 答：重新readResolve方法。
 *
 * @author sue
 * @date 2023/2/17 23:46
 */
public class SimpleSingleton9 implements Serializable {
    private SimpleSingleton9() {
        if (Inner.INSTANCE != null) {
            throw new RuntimeException("不能支持重复实例化");
        }
    }

    public static SimpleSingleton9 getInstance() {
        return Inner.INSTANCE;
    }

    private static class Inner {
        private static final SimpleSingleton9 INSTANCE = new SimpleSingleton9();
    }

    private static void writeFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            SimpleSingleton5 simpleSingleton5 = SimpleSingleton5.getInstance();
            fos = new FileOutputStream(new File("test.txt"));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(simpleSingleton5);
            System.out.println(simpleSingleton5.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private static void readFile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File("test.txt"));
            ois = new ObjectInputStream(fis);
            SimpleSingleton5 myObject = (SimpleSingleton5) ois.readObject();

            System.out.println(myObject.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object readResolve() throws ObjectStreamException {
        return Inner.INSTANCE;
    }
}
