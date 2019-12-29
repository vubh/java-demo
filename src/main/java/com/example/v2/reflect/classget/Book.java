package com.example.v2.reflect.classget;

public class Book {
    static {
        System.out.println("静态块初始化");
    }

    {
        System.out.println("代码块初始化");
    }

    public Book() {
        System.out.println("无参构造初始化");
    }
}
