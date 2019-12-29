package com.example.v3.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ScheduledExecutorService 和 Timer对比
 * （建议使用ScheduledExecutorServiceTest代替Timer）
 *
 * Timer定时任务
 *
 * task1每隔2秒执行
 * task2任务应该没隔1秒执行，实际情况确不是
 *
 * 同一个Timer实例运行多个TimerTask，时间间隔问题
 */
public class TimerTaskTest {

    private static SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {

        Timer timer = new Timer();

        TimerTask task1 = new TimerTask() {
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

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("任务2：" + df.format(new Date()));
            }
        };

        timer.schedule(task1, 0, 1000);
        timer.schedule(task2, 0, 1000);

    }
}
