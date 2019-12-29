package com.example.v2.thread.unsafe;


import com.example.v2.thread.unsafe.Ticket;

/**
 * 线程安全经典实例
 */
public class TicketTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(ticket, "窗口1").start();
        new Thread(ticket, "窗口2").start();
        new Thread(ticket, "窗口3").start();

    }
}
