package com.example.v2.thread.unsafe.syn;


/**
 * synchronized解决线程安全问题
 */
public class SynTicketTest {
    public static void main(String[] args) {
        SynTicket ticket = new SynTicket();

        new Thread(ticket, "窗口1").start();
        new Thread(ticket, "窗口2").start();
        new Thread(ticket, "窗口3").start();

    }
}
