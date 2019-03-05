package com.gupao.learn.design.model.singleton.serializable;

import java.io.Serializable;

/**
 * Description:序列化与反序列化时实现单例
 *      反序列化时会破坏单例，只需要重写readResolve，即可解决。
 *
 *      序列化：将内存中的状态，通过转换成字节码的形式，形成一个IO流，
 *             并写入到其他地方（例如磁盘、网络IO），将内存中的状态永久保存下来。
 *      反序列化：将已经持久化的字节码内容，转换成IO流，通过读取IO流，
 *             将读取的内容转换为JAVA对象。转换过程中会重新创建对象。
 *
 * @author 轩辚
 * @date 2019/3/5 0:21
 */
public class SerializableSingleton implements Serializable {
    /**
     * 1.私有化构造方法。
     */
    private SerializableSingleton(){}

    /**
     * 2.静态的实例。
     */
    private static final SerializableSingleton serializableSingleton = new SerializableSingleton();

    /**
     * 3.提供公共的获取实例的方法。
     */
    public static SerializableSingleton getInstance(){
        return serializableSingleton;
    }

    /**
     * 4.重写readResolve方法。不重写的话单例就会被破坏掉。
     */
    private Object readResolve(){
        return serializableSingleton;
    }
}
