package com.gupao.learn.design.model.singleton.lazy;

/**
 * Description:懒汉式单例模式-线程不安全
 *      在外部需要的时候才进行实例化
 *
 * @author 轩辚
 * @date 2019/3/4 23:47
 */
public class LazySingletonThreadUnsafe {
    /**
     * 1.私有化构造方法。
     */
    private LazySingletonThreadUnsafe(){}

    /**
     * 2.静态的实例。
     */
    private static LazySingletonThreadUnsafe lazySingletonThreadUnsafe = null;

    /**
     * 3.提供公共的获取实例的方法。
     */
    public static LazySingletonThreadUnsafe getInstance(){
        //调用时判断实例是否初始化，如果没有初始化，则进行初始化并赋值
        if(null == lazySingletonThreadUnsafe){
            lazySingletonThreadUnsafe = new LazySingletonThreadUnsafe();
        }
        return lazySingletonThreadUnsafe;
    }
}
