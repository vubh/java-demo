package com.example.v2.thread.concurrent;

import java.util.concurrent.*;

public class CallDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(new AddNumberTask());
        System.out.println(Thread.currentThread().getName() + "线程执行其他任务");
        Integer integer = future.get();
        System.out.println(integer);
        // 关闭线程池
        if (executor != null)
            executor.shutdown();
    }
}


class AddNumberTask implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("####AddNumberTask###call()");
        Thread.sleep(5000);
        return 5000;

    }
}