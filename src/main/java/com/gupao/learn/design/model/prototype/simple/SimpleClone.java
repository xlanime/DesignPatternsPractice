package com.gupao.learn.design.model.prototype.simple;

import com.gupao.learn.design.model.factory.beans.Apple;

/**
 * Description:原型模式-浅复制
 *
 * @author 轩辚
 * @date 2019/3/5 0:36
 */
public class SimpleClone implements Cloneable{

    private String name = "SimpleClone";

    private Apple apple = new Apple();

    public String getName() {
        return name;
    }

    public Apple getApple() {
        return apple;
    }

    /**
     * 重写Clone方法
     * @return clone后的对象
     * @throws CloneNotSupportedException 不支持clone的异常
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
