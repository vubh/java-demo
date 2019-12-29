package com.example.v2.reflect.classget;

public class Test {
    public static void main(String[] args) throws Exception {
        //Class cls = Book.class;

        /**
         * 静态块初始化
         */
        //Class.forName("com.example.v2.reflect.classget.Book");

        /**
         * 静态块初始化
         * 代码块初始化
         * 无参构造初始化
         */
        new Book().getClass();
    }
}
