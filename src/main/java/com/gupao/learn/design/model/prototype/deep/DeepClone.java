package com.gupao.learn.design.model.prototype.deep;

import com.gupao.learn.design.model.utils.StreamUtil;

import java.io.*;

/**
 * Description:原型模式-深度复制
 * 1、深复制和浅复制。
 * 简单理解，深复制就是完全复制一个新的对象出来，修改新对象的属性与原对象无关。
 * 而浅复制就只是复制了一个新的对象，属性还是原来的对象的，修改后影响原来的对象。
 * 深复制利用序列化实现。
 * 2、原型模式：
 * 简单讲，原型模式就是有一个原型，将它复制为新的对象，实现业务分离。
 * 例如DTO和VO，从数据库查出DTO后，将其属性赋值给VO，再传给View使用，这就是原型模式的实现。
 *
 * @author 轩辚
 * @date 2019/3/5 0:34
 */
public class DeepClone implements Cloneable, Serializable {

    private String name;
    {
        name = "DeepClone";
    }

    private DeepCloneApple apple = new DeepCloneApple();

    public String getName() {
        return name;
    }

    public DeepCloneApple getApple() {
        return apple;
    }

    /**
     * 重写Clone方法
     *
     * @return clone后的对象
     */
    @Override
    public Object clone() {
        return this.deepClone();
    }

    /**
     * 深度复制的方法，利用序列化实现
     *
     * @return 深度复制得到的对象
     */
    private Object deepClone() {
        //声明需要用到的流
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        DeepClone deepClone = null;
        try {
            //首先将本对象序列化
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            //然后进行反序列化
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            deepClone = (DeepClone) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            StreamUtil.closeOutputStream(byteArrayOutputStream);
            StreamUtil.closeOutputStream(objectOutputStream);
            StreamUtil.closeInputStream(byteArrayInputStream);
            StreamUtil.closeInputStream(objectInputStream);
        }
        //将得到的对象返回
        return deepClone;
    }
}
