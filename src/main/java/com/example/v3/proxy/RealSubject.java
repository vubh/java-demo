package com.example.v3.proxy;

/**
 * 被代理的真实对象
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("执行request方法");
    }

    @Override
    public void sayHello() {
        System.out.println("执行sayHello方法");
    }
}
