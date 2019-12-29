package com.example.v2.thread.concurrent.QueueDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrs = new ArrayBlockingQueue<>(3);
        arrs.add("测试1");
        arrs.add("测试2");
        arrs.add("测试3");
        arrs.offer("测试4", 1, TimeUnit.SECONDS);

        System.out.println(arrs.size());

        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(3);
        linkedBlockingQueue.add("张三");
        linkedBlockingQueue.add("李四");
        linkedBlockingQueue.add("李四");
        System.out.println(linkedBlockingQueue.size());

    }
}
