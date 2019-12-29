//package com.example.v3.proxy;
//
//
//import org.springframework.cglib.proxy.Enhancer;
//
//import java.lang.reflect.Proxy;
//
///**
// * 测试
// */
//public class Test {
//    public static void main(String[] args) {
//        testDynamicProxy();
//        testCglibDynamicProxy();
//    }
//
//    public static void testStaticProxy(){
//        RealSubject subject = new StaticProxy(new RealSubject());
//        subject.request();
//    }
//
//    public static void testDynamicProxy(){
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        Subject subject = (Subject)Proxy.newProxyInstance(DynamicProxy.class.getClassLoader(),
//                                                           new Class[]{Subject.class},
//                                                           new DynamicProxy(new RealSubject()));
//        //subject.request();
//        subject.sayHello();
//    }
//
//    public static void testCglibDynamicProxy(){
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(v3.proxy.RealSubject.class);
//        enhancer.setCallback(new CglibDynamicProxy());
//        Subject subject = (Subject)enhancer.create();
//        subject.request();
//    }
//}
