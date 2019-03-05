package com.gupao.learn.design.model.singleton;

import com.gupao.learn.design.model.singleton.hungry.HungrySingleton;
import com.gupao.learn.design.model.singleton.lazy.LazySingletonInnerClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;

/**
 * Description:
 *
 * @author 轩辚
 * @date 2019/3/5 0:23
 */
public class SingletonModelTest {
    /**
     * 初始化日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(SingletonModelTest.class);

    /**
     * 单例模式无法在单元测试中测试，因为单元测试的时候，单例并不会实例化，
     * 因此这里使用main方法进行测试。
     * @param args main方法入参
     */
    public static void main(String[] args) {
        //饿汉式单例测试，懒汉式单例测试就和这个一样，这里就不写了
        logger.info("饿汉式单例测试");
        SingletonTest();

        logger.info("静态内部类单例测试");
        //InnerClassSingletonTest();
    }

    /**
     * 利用CountDownLatch实现并发模拟测试：饿汉式单例模式
     */
    private static void SingletonTest(){
        //执行模拟并发的次数
        int count = 200;
        //初始化CountDownLatch
        final CountDownLatch countDownLatch = new CountDownLatch(count);

        long startTime = System.currentTimeMillis();
        //使用for循环初始化线程
        for (int i = 0 ; i < count ; i++){
            new Thread(){
                @Override
                public void run() {
                    try {
                        //使用countDownLatch阻塞线程
                        try {
                            //当countDownLatch数量减为1的时候，解除阻塞
                            countDownLatch.await();
                        } catch (InterruptedException e) {
                            logger.info("CountDownLatch阻塞线程时出现异常：", e);
                        }

                        //获取实例，并输出实例地址
                        Object singleton = LazySingletonInnerClass.getInstance();
                        logger.info("饿汉式单例实例：" + singleton);

                    }catch(Exception e){
                        logger.info("线程异常：",e);
                    }
                }
            }.start();
            //循环一次数量减1
            countDownLatch.countDown();
        }
        long endTime = System.currentTimeMillis();
        logger.info("测试耗时："+(endTime - startTime));
    }

    /**
     * 静态内部类单例测试
     */
    private static void InnerClassSingletonTest(){
        //获取到LazySingletonInnerClass
        Class<?> clazz = LazySingletonInnerClass.class;

        try {
            //通过反射获取到LazySingletonInnerClass的私有构造器
            Constructor constructor = clazz.getDeclaredConstructor();
            //设置可以强制访问对象
            constructor.setAccessible(true);
            //通过构造器获得单例对象
            Object lazySingletonInnerClass1 = constructor.newInstance();
            Object lazySingletonInnerClass2 = constructor.newInstance();
            logger.info("获取到的两个单例对象：");
            logger.info("1:"+lazySingletonInnerClass1);
            logger.info("2:"+lazySingletonInnerClass2);
            logger.info("两个对象是否相同："+(lazySingletonInnerClass1==lazySingletonInnerClass2));
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    
}
