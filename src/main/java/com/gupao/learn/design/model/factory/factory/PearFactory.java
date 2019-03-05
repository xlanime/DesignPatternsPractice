package com.gupao.learn.design.model.factory.factory;

import com.gupao.learn.design.model.factory.beans.Pear;

/**
 * Description:梨工厂
 *
 * @author 轩辚
 * @date 2019/3/4 18:23
 */
public class PearFactory implements FruitFactory{
    @Override
    public Pear getFruit() {
        return new Pear();
    }
}
