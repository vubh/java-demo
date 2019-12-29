package com.example.v3.design.singleton;

/**
 *饿汉模式
 */
public class Singleton1 {
    // 私有构造方法，防止被实例化(new Singleton)
    private Singleton1(){}


    /**
     * 创建唯一实例
     * private:防止外部修改实例对象 Singleton1.instance=null
     * static：只加载一次，保证对象唯一
     */
    private static Singleton1 instance = new Singleton1();

    //提供给外部调用
    public static Singleton1 getInstance()
    {
        return instance;
    }

    public static void main(String[] args) {
        //如果instance不是static修饰此处执行会出现栈内存溢出
        new Singleton1();
    }
}
