package com.gupao.learn.design.model.factory.factory;

import com.gupao.learn.design.model.factory.beans.Orange;

/**
 * Description:橘子工厂
 *
 * @author 轩辚
 * @date 2019/3/4 18:23
 */
public class OrangeFactory implements FruitFactory{
    @Override
    public Orange getFruit() {
        return new Orange();
    }
}