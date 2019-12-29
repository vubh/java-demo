package com.example.v3.design.singleton;

/**
 * 懒汉模式  存在线程安全问题
 */
public class Singleton2 {
    // 私有构造方法，防止被实例化(new Singleton)
    private Singleton2(){}

    //创建唯一实例
    private static Singleton2 instance = null;

    public static Singleton2 getInstance()
    {
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}
