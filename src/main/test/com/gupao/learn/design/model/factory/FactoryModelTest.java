package com.gupao.learn.design.model.factory;

import com.gupao.learn.design.model.factory.abstractfactory.AbstractFruitFactory;
import com.gupao.learn.design.model.factory.beans.Apple;
import com.gupao.learn.design.model.factory.beans.Consts;
import com.gupao.learn.design.model.factory.beans.Orange;
import com.gupao.learn.design.model.factory.beans.Pear;
import com.gupao.learn.design.model.factory.factory.AppleFactory;
import com.gupao.learn.design.model.factory.factory.OrangeFactory;
import com.gupao.learn.design.model.factory.factory.PearFactory;
import com.gupao.learn.design.model.factory.simple.SimpleFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:工厂模式测试类
 *    工厂模式的意义在于将对象的创建过程，对用户隐藏了。
 *    用户不需要关心创建对象的过程多么复杂，只需要关心创建的结果即可。
 *
 * @author 轩辚
 * @date 2019/3/4 17:55
 */
public class FactoryModelTest {

    /**
     * 初始化日志对象
     */
    private Logger logger = LoggerFactory.getLogger(FactoryModelTest.class);

    /**
     * 工厂模式测试入口
     */
    @Test
    public void factoryModelTestApi(){
        logger.info("不使用工厂模式：");
        noFactoryModelTest();

        logger.info("使用简单工厂模式：");
        simpleFactoryModelTest();

        logger.info("使用工厂模式");
        factoryModelTest();

        logger.info("使用抽象工厂模式");
        abstractFactoryModelTest();
    }

    /**
     * 不使用工厂模式的情况下，需要什么对象就得手动创建一个。
     * 用户使用起来不方便，需要知道如何去创建一个对象。
     */
    @Test
    public void noFactoryModelTest(){
        Apple apple = new Apple();
        logger.info(apple.getName());

        Pear pear = new Pear();
        logger.info(pear.getName());

        Orange orange = new Orange();
        logger.info(orange.getName());
    }

    /**
     * 使用简单工厂模式的情况下，可以根据客户需要返回对应的对象。
     * 客户只需要告诉简单工厂，自己需要什么，即可得到对应的对象。
     * 用户可以不再关心对象的创建，但是需要明确告诉工厂自己的需要，容易出错。
     */
    @Test
    public void simpleFactoryModelTest(){
        SimpleFactory simpleFactory = new SimpleFactory();
        Apple apple = (Apple)simpleFactory.getFruit(Consts.APPLE);
        logger.info(apple.getName());

        Pear pear = (Pear)simpleFactory.getFruit(Consts.PEAR);
        logger.info(pear.getName());

        Orange orange = (Orange)simpleFactory.getFruit(Consts.ORANGE);
        logger.info(orange.getName());
    }

    /**
     * 工厂模式：每个工厂生产对应的对象。用户只需要到对应的工厂，即可获取对应的对象。
     * 但是用户需要知道正确的工厂，所以也是比较麻烦的。
     */
    @Test
    public void factoryModelTest(){
        AppleFactory appleFactory = new AppleFactory();
        Apple apple = appleFactory.getFruit();
        logger.info(apple.getName());

        PearFactory pearFactory = new PearFactory();
        Pear pear = pearFactory.getFruit();
        logger.info(pear.getName());

        OrangeFactory orangeFactory = new OrangeFactory();
        Orange orange = orangeFactory.getFruit();
        logger.info(orange.getName());
    }

    /**
     * 抽象工厂模式：Spring中最常用的设计模式之一、
     * 用户只需要选择即可，不需要知道如何创建对象，需要什么对象。
     */
    @Test
    public void abstractFactoryModelTest(){
        AbstractFruitFactory abstractFruitFactory = new AbstractFruitFactory();
        Apple apple = abstractFruitFactory.getApple();
        logger.info(apple.getName());

        Pear pear = abstractFruitFactory.getPear();
        logger.info(pear.getName());

        Orange orange = abstractFruitFactory.getOrange();
        logger.info(orange.getName());
    }

}
