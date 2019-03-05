package com.gupao.learn.design.model.factory.factory;

import com.gupao.learn.design.model.factory.beans.Apple;

/**
 * Description:苹果工厂
 *
 * @author 轩辚
 * @date 2019/3/4 18:23
 */
public class AppleFactory implements FruitFactory{
    @Override
    public Apple getFruit() {
        return new Apple();
    }
}
