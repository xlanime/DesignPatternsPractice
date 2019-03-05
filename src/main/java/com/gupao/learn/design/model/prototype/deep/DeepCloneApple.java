package com.gupao.learn.design.model.prototype.deep;

import com.gupao.learn.design.model.factory.beans.Fruit;

import java.io.Serializable;

/**
 * Description:
 *
 * @author 轩辚
 * @date 2019/3/5 22:33
 */
public class DeepCloneApple implements Fruit, Serializable {
    @Override
    public String getName() {
        return "Apple";
    }
}
