package com.example.v2.thread.unsafe.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁解决线程安全问题
 */
public class LockTicket implements Runnable {

    private int tickets = 100;

    /**
     * 造锁
     */
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            try {
                // 加锁
                lock.lock();

                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()
                            + "正在出售第" + (tickets--) + "张票");
                }
            } finally {
                //释放锁
                lock.unlock();
            }
        }
    }
}
