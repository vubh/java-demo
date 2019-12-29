package com.example.v3.proxy;

/**
 * 静态代理
 */
public class StaticProxy implements Subject {

    private RealSubject realSubject;

    public StaticProxy(RealSubject realSubject){
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("代理前添加的");
        realSubject.request();
        System.out.println("代理后添加的");
    }

    @Override
    public void sayHello() {
        System.out.println("代理前添加的");
        realSubject.sayHello();
        System.out.println("代理后添加的");
    }
}
