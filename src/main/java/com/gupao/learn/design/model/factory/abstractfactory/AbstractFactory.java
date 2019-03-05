package com.gupao.learn.design.model.factory.abstractfactory;

import com.gupao.learn.design.model.factory.beans.Apple;
import com.gupao.learn.design.model.factory.beans.Orange;
import com.gupao.learn.design.model.factory.beans.Pear;

/**
 * Description:抽象水果工厂
 *
 * @author 轩辚
 * @date 2019/3/4 18:31
 */
public abstract class AbstractFactory {
    /**
     * 获取苹果对象
     * @return 苹果对象
     */
    public abstract Apple getApple();

    /**
     * 获取橘子对象
     * @return 橘子对象
     */
    public abstract Orange getOrange();

    /**
     * 获取梨对象
     * @return 梨对象
     */
    public abstract Pear getPear();
}
