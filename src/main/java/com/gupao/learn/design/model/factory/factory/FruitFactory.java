package com.gupao.learn.design.model.factory.factory;

import com.gupao.learn.design.model.factory.beans.Fruit;

/**
 * Description:水果工厂
 *
 * @author 轩辚
 * @date 2019/3/4 18:25
 */
public interface FruitFactory {
    /**
     * 获取指定的水果对象
     * @return 获取到的水果对象
     */
    Fruit getFruit();
}
