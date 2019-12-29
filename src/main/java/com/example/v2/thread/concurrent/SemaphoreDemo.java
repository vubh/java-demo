package com.example.v2.thread.concurrent;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 计数信号量
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore wc = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            ThreadDemo demo = new ThreadDemo("第"+(i+1)+"个人", wc);
            demo.start();
        }
    }
}

class ThreadDemo extends Thread{
    private String name;
    private Semaphore wc;

    public ThreadDemo(String name, Semaphore wc){
        this.name=name;
        this.wc=wc;
    }

    @Override
    public void run() {
        //剩下的资源
        int availablePermits = wc.availablePermits();

        if(availablePermits>0){
            System.out.println(name + "天助我也，终于有茅坑了.....");
        }else {
            System.out.println(name + "怎么没有茅坑了...");
        }

        try {
            //申请资源
            wc.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + "终于上厕所啦.爽啊" + ",剩下厕所:" + wc.availablePermits());

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(name + "厕所上完啦!");
        // 释放资源
        wc.release();
    }
}