package com.gupao.learn.design.model.singleton.lazy;

/**
 * Description:懒汉式单例模式-静态内部类（线程安全，性能较好）
 *         内部类只有在外部类被调用的时候才会被加载。
 *
 * @author 轩辚
 * @date 2019/3/4 23:49
 */
public class LazySingletonInnerClass {
    /**
     * 判断类是否初始化的标识
     */
    private static boolean initialized = false;

    /**
     * 私有化构造方法。
     * 这里是加锁避免反射入侵。
     */
    private LazySingletonInnerClass(){
        synchronized (LazySingletonInnerClass.class) {
            if (!initialized) {
                initialized = true;
            } else {
                throw new RuntimeException("单例已被侵犯！");
            }
        }
    }

    /**
     * 提供公共的获取实例的方法。如果不加锁可能导致线程安全问题。
     */
    public static LazySingletonInnerClass getInstance(){
        return LazyHolder.lazySingletonInnerClass;
    }

    /**
     * 静态内部类，默认不加载。只有调用LazyHolder的时候才加载。
     */
    private static class LazyHolder{
        private static final LazySingletonInnerClass lazySingletonInnerClass = new LazySingletonInnerClass();
    }
}
