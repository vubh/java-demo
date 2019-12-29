package com.example.v1.constructor;

import java.util.Random;

public class User {
    private static int nextId;

    private int id;
    private String name = "";
    private double salary;

    // 静态代码块 一次
    static {
        Random generator = new Random();
        // set nextId to a random number between 0 and 9999
        nextId = generator.nextInt(10000);
    }

    // 构造代码块 每次new创建对象时都会被调用
    {
        id = nextId;
        nextId++;
    }


    {
        System.out.println("代码块");
    }

    // 三个重载的构造函数

    public User(String n, double s) {
        name = n;
        salary = s;
    }

    public User(double s) {
        // 调用两参构造函数
        this("User #" + nextId, s);
    }

    // 默认的构造函数

    public User() {
        // name initialized to ""--see above
        // salary not explicitly set--initialized to 0
        // id initialized in initialization block
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}
