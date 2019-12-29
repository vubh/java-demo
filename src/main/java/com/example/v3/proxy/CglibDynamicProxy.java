//package com.example.v3.proxy;
//
//import org.springframework.cglib.proxy.MethodInterceptor;
//import org.springframework.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//
///**
// * cglib代理
// */
//public class CglibDynamicProxy implements MethodInterceptor {
//
//    @Override
//    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//        System.out.println("cglib代理前");
//        Object result = null;
//        result = methodProxy.invokeSuper(o, objects);
//        System.out.println("cglib代理后");
//        return result;
//    }
//}
