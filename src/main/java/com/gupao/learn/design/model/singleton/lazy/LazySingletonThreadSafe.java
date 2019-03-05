package com.gupao.learn.design.model.singleton.lazy;

/**
 * Description:懒汉式单例模式-线程安全（加锁保证线程安全但是导致性能降低）
 *
 * @author 轩辚
 * @date 2019/3/4 23:47
 */
public class LazySingletonThreadSafe {
    /**
     * 1.私有化构造方法。
     */
    private LazySingletonThreadSafe(){}

    /**
     * 2.静态的实例。
     */
    private static LazySingletonThreadSafe lazySingletonThreadSafe = null;

    /**
     * 3.提供公共的获取实例的方法。
     */
    public static synchronized LazySingletonThreadSafe getInstance(){
        if(null == lazySingletonThreadSafe){
            lazySingletonThreadSafe = new LazySingletonThreadSafe();
        }
        return lazySingletonThreadSafe;
    }
}
