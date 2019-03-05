package com.gupao.learn.design.model.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:注册登记式单例模式
 *     Spring中主要用的就是这种单例模式
 * @author 轩辚
 * @date 2019/3/5 0:19
 */
public class RegisterSingleton {
    //使用Map，每次使用的时候向Map中插入相应的信息。不能使用HashMap，因为HashMap线程不安全。

    /**
     * 私有化构造方法
     */
    private RegisterSingleton(){}

    /**
     * 声明用于注册的Map
     */
    private static Map<String,RegisterSingleton> ioc = new ConcurrentHashMap<>();

    /**
     * 获取实例：当实例名存在时，直接返回实例，否则在ioc中注册实例信息。
     *
     * @param instanceName 实例的名称
     * @return 获取到的实例
     */
    public static RegisterSingleton getInstance(String instanceName){
        //如果传入的实例名为空，以类名作为实例名
        if(instanceName == null){
            instanceName = RegisterSingleton.class.getName();
        }
        //判断注册map中是否已有对应的实例，没有则注册一个
        if(ioc.get(instanceName) == null){
            ioc.put(instanceName,new RegisterSingleton());
        }
        //从注册map中取出已注册的实例，并返回
        return ioc.get(instanceName);
    }
}
