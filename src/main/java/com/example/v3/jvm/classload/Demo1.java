package com.example.v3.jvm.classload;

public class Demo1 {
    public static void main(String[] args) {
        try {
            System.out.println("系统加载器：" + ClassLoader.getSystemClassLoader());
            ClassLoader c = Demo1.class.getClassLoader().getSystemClassLoader();
            System.out.println("Demo1类加载器：" + c);

            System.out.println("Demo1类加载器父加载器：" + c.getParent());

            Class o = Class.forName("java.lang.Object");

            //为了安全，不提供根加载器的引用
            System.out.println("根加载器：" + o.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
