package com.example.v2.thread.base;

/**
 * volatile 保证线程可见性
 */
public class VolatileDemo extends Thread{

    public volatile static boolean flag = true;

    @Override
    public void run() {
        System.out.println("开始....");
        while (flag) {

        }
        System.out.println("结束...");
    }

    public void setRuning(boolean flag) {
        VolatileDemo.flag = flag;
    }

    public static void main(String[] args) throws InterruptedException {

        VolatileDemo volatileDemo = new VolatileDemo();
        volatileDemo.start();

        /**
         * 主线程3秒后，设置共享变量flag为false
         * volatile修饰共享变量，子线程读取到改变后的flag,跳出循环，打印结束...
         * 无volatile修饰共享变量时，子线程一直在死循环
         */

        Thread.sleep(3000);
        volatileDemo.setRuning(false);
        System.out.println("flag值改为false");

        Thread.sleep(1000);
        System.out.println("flag:"+ VolatileDemo.flag);
    }
}
