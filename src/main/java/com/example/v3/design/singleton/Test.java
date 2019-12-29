package com.example.v3.design.singleton;


import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s2 = Singleton1.getInstance();
        System.out.println(s1.equals(s2));

        Singleton2 s3 = Singleton2.getInstance();
        Singleton2 s4 = Singleton2.getInstance();
        System.out.println(s3.equals(s4));

    }
}
