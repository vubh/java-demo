package com.example.v1.constructor;

/**
 * 构造函数
 *
 * 执行顺序：
 * 静态代码块->构造代码块->构造函数->普通代码块
 */
public class ConstructorTest {
    public static void main(String[] args) {

        User[] users = new User[3];

        users[0] = new User("张三", 40000);
        users[1] = new User(60000);
        users[2] = new User();


        for (User e : users) {
            System.out.println("姓名=" + e.getName() + ",id=" + e.getId() + ",薪水="
                    + e.getSalary());
        }
    }
}
