package com.example.v3.jvm;

public class Test {
    public static void main(String[] args) {

        //byte[] bytes = new byte[4 * 1024 * 1024];
        //System.out.println("分配4M内存");

        System.out.println("最大内存"+Runtime.getRuntime().maxMemory()/1024/1024);
        System.out.println("可用内存"+Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("已使用内存"+Runtime.getRuntime().totalMemory()/1024/1024);
    }
}
