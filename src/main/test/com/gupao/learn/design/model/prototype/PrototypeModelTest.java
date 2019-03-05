package com.gupao.learn.design.model.prototype;

import com.gupao.learn.design.model.prototype.deep.DeepClone;
import com.gupao.learn.design.model.prototype.simple.SimpleClone;
import com.gupao.learn.design.model.singleton.SingletonModelTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:原型模式测试
 *
 * @author 轩辚
 * @date 2019/3/5 10:54
 */
public class PrototypeModelTest {
    /**
     * 初始化日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(PrototypeModelTest.class);

    /**
     * 浅复制测试：将对象直接复制地址。
     */
    @Test
    public void simpleCloneTest() {
        SimpleClone simpleClone = new SimpleClone();
        try {
            SimpleClone simpleCloneResult = (SimpleClone) simpleClone.clone();
            logger.info("原对象：" + simpleClone);
            logger.info("Clone得到的对象：" + simpleCloneResult);
            logger.info("克隆得到的对象是否是同一个对象：" + (simpleClone == simpleCloneResult));
            logger.info("克隆得到的对象的属性是否是同一个对象:" + (simpleClone.getApple() == simpleCloneResult.getApple()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 深复制测试：只复制原对象的值
     */
    @Test
    public void deepCloneTest() {
        DeepClone deepClone = new DeepClone();
        DeepClone deepCloneResult = (DeepClone) deepClone.clone();
        logger.info("原对象：" + deepClone);
        logger.info("Clone得到的对象：" + deepCloneResult);
        logger.info("克隆得到的对象是否是同一个对象：" + (deepClone == deepCloneResult));
        logger.info("克隆得到的对象的属性是否是同一个对象:" + (deepClone.getApple() == deepCloneResult.getApple()));
        logger.info("克隆得到的对象的name属性:" + (deepClone.getName() +" - "+ deepCloneResult.getName()));
    }
}
