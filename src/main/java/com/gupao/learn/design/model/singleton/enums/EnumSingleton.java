package com.gupao.learn.design.model.singleton.enums;

/**
 * Description:枚举实现单例（枚举只会加载一次）
 *      常量使用枚举实现单例比较好。通常在通用API中使用。
 *      这里只是练习使用，因此没有构造严谨的测试数据。
 *      enum有自身的属性，并且需要提供对应的get方法。具体的实例可以有自己的方法，
 *      通过重写get方法，来实现获取到具体实例自己的属性。
 *      如果不重写，则默认获取的是enum的属性。
 *
 * @author 轩辚
 * @date 2019/3/5 0:14
 */
public enum EnumSingleton {
    /**
     * 实例1,苹果
     */
    APPLE() {
        private String name = "Apple";
        private double price = 7.55;

        @Override
        public String getName() {
            return name;
        }

        @Override
        public double getPrice() {
            return price;
        }
    },

    /**
     * 实例2,橘子
     */
    ORANGE() {
        private String name = "Orange";
        private double price = 4.88;

        @Override
        public String getName() {
            return name;
        }

        @Override
        public double getPrice() {
            return price;
        }
    },

    /**
     * 单纯的实例
     */
    INSTANCE;

    /**
     * 名称
     */
    private String name = "INSTANCE";

    /**
     * 价格
     */
    private double price = 100.00;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
