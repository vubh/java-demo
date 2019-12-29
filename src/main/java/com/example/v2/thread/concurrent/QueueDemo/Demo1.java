package com.example.v2.thread.concurrent.QueueDemo;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 非阻塞队列
 */
public class Demo1 {
    public static void main(String[] args) {
        ConcurrentLinkedQueue q = new ConcurrentLinkedQueue();
        q.add("测试1");
        q.offer("测试2");
        q.add("测试3");
        q.add("测试4");

        //从头获取元素,删除该元素
        System.out.println(q.poll()+",队列剩余："+q.size());

        //从头获取元素,不刪除该元素
        System.out.println(q.peek()+",队列剩余："+q.size());
    }
}
