package com.example.v1;

import java.util.Scanner;

/**
 * 控制台输入
 */
public class InputTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // get first input
        System.out.print("请输入姓名！");
        String name = in.nextLine();

        // get second input
        System.out.print("请输入年龄！");
        int age = in.nextInt();

        // 控制的显示输出
        System.out.println("你好, " + name + "！明年你就" + (age + 1) + "岁了！");

    }
}
