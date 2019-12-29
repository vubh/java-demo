package com.example.v2.thread.base;

/**
 * 守护线程和非守护线程
 */
public class DaemonDemo {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            for(int i=0; i<30; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程"+i);
            }
        });

        //该线程标记为守护线程,即随主线程的结束而结束
        t1.setDaemon(true);
        t1.start();


        for(int i=0; i<5; i++){
            Thread.sleep(500);
            System.out.println("主线程"+i);
        }
        System.out.println("主线程执行完毕");
    }
}