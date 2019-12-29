package com.example.v2.thread.unsafe.lock;

/*
 * 为了更清楚的让我们知道是如何加锁和释放锁的，JDK5以后就提供了一个接口：Lock锁。
 * Lock
 * 		public void lock():加锁
 * 		public void unlock():释放锁
 * 实现类对象
 * 		public ReentrantLock()
 */

public class LockTicketTest {
    public static void main(String[] args) {
        LockTicket ticket = new LockTicket();

        new Thread(ticket, "窗口1").start();
        new Thread(ticket, "窗口2").start();
        new Thread(ticket, "窗口3").start();

    }
}
