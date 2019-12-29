package com.example.v2.thread.base;

/**
 *主线程在t1线程之后执行
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                System.out.println("子线程"+i);
            }
        });
        t1.start();

        t1.join();
        for (int i = 0; i < 30; i++) {
            System.out.println("主线程"+i);
        }
    }
}