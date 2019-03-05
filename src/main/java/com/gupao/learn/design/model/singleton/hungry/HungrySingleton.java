package com.gupao.learn.design.model.singleton.hungry;

/**
 * Description:饿汉式单例模式
 *      不管是否使用，类加载的时候就初始化，将单例创建出来。
 *      优点：没有使用锁，执行效率高。
 *      缺点：类加载的时候就初始化，不管是否使用都占用空间，浪费了内存资源。
 *
 * 单例实现的基本操作：
 *      1.私有化构造方法。
 *      2.静态的实例。
 *      3.提供公共的获取实例的方法。
 *
 * @author 轩辚
 * @date 2019/3/4 23:47
 */
public class HungrySingleton {
    /**
     * 1.私有化构造方法。
     */
    private HungrySingleton(){}

    /**
     * 2.静态的实例。
     */
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    /**
     * 3.提供公共的获取实例的方法。
     */
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
