package com.example.v2.thread.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 计数器
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ",子线程开始执行...");
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + ",子线程结束执行...");
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ",子线程开始执行...");
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + ",子线程结束执行...");
        }).start();

        try {
            countDownLatch.await();// 減去为0,恢复任务继续执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("两个子线程执行完毕....");

        System.out.println("主线程继续执行.....");
        for (int i = 0; i < 10; i++) {
            System.out.println("main,i:" + i);
        }

    }
}
