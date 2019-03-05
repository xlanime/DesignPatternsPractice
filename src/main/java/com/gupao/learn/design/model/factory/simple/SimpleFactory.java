package com.gupao.learn.design.model.factory.simple;

import com.gupao.learn.design.model.factory.beans.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:简单工厂模式
 *
 * @author 轩辚
 * @date 2019/3/4 18:02
 */
public class SimpleFactory {
    /**
     * 初始化日志对象
     */
    private Logger logger = LoggerFactory.getLogger(SimpleFactory.class);

    /**
     * 根据用户需要的水果名，返回水果对象
     * @param fruitName 水果名
     * @return 水果对象
     */
    public Fruit getFruit(String fruitName){
        if(Consts.APPLE.equals(fruitName)){
            return new Apple();
        }else if(Consts.PEAR.equals(fruitName)){
            return new Pear();
        }else if(Consts.ORANGE.equals(fruitName)){
            return new Orange();
        }else{
            logger.info("没有找到对应的对象");
            return null;
        }
    }
}
