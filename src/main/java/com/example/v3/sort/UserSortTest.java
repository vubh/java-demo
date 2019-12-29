package com.example.v3.sort;

import java.util.Arrays;

/**
 * 根据用户年龄排序
 */
public class UserSortTest {
    public static void main(String[] args) {
        User[] u = new User[3];
        u[0] = new User("张一", 10);
        u[1] = new User("张二", 5);
        u[2] = new User("张三", 9);

        System.out.println(Arrays.toString(u));

        Arrays.sort(u);

        System.out.println(Arrays.toString(u));
    }
}
