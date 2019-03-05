package com.gupao.learn.design.model.factory.abstractfactory;

import com.gupao.learn.design.model.factory.beans.Apple;
import com.gupao.learn.design.model.factory.beans.Orange;
import com.gupao.learn.design.model.factory.beans.Pear;

/**
 * Description:抽象水果工厂类的实现
 *
 * @author 轩辚
 * @date 2019/3/4 18:33
 */
public class AbstractFruitFactory extends AbstractFactory{
    @Override
    public Apple getApple() {
        return new Apple();
    }

    @Override
    public Orange getOrange() {
        return new Orange();
    }

    @Override
    public Pear getPear() {
        return new Pear();
    }
}
