package com.example.v1.timer;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * timer的schedule方法和scheduleAtFixedRate方法区别
 *
 * schedule：如果指定时间已过去，从当前时间开始，之前不管
 *
 * scheduleAtFixedRate：指定时间已过去，会补回指定时间到现在的任务
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("测试");
            }
        };

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -1);

        //timer.schedule(task, calendar.getTime(), 1000);

        timer.scheduleAtFixedRate(task, calendar.getTime(), 1000);
    }
}
