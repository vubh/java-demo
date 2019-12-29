package com.example.v3.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService 和 Timer对比
 * （建议使用ScheduledExecutorServiceTest代替Timer）
 *
 * 同一个ScheduledExecutorService对象维护多个定时任务，没有出现Timer遇到的问题
 */
public class ScheduledExecutorServiceTest {

    private static SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {


        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("任务1：" + df.format(new Date()));

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("任务2：" + df.format(new Date()));
            }
        };

        ScheduledExecutorService ss = new ScheduledThreadPoolExecutor(2);
        ss.scheduleAtFixedRate(task1, 0, 1, TimeUnit.SECONDS);
        ss.scheduleAtFixedRate(task2, 0, 1, TimeUnit.SECONDS);

    }
}
