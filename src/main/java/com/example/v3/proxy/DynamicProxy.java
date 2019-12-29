package com.example.v3.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 */
public class DynamicProxy implements InvocationHandler {
    private Object realSubject;

    public DynamicProxy(Object realSubject) {
        this.realSubject = realSubject;
    }

    /**
     *
     * 重载方法
     * @param proxy 所代理的真实对象
     * @param method 所要调用真实对象的某个方法的Method对象
     * @param args 调用真实对象某个方法时接受的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理前");
        method.invoke(realSubject, args);
        System.out.println("动态代理后");
        return realSubject;
    }
}
