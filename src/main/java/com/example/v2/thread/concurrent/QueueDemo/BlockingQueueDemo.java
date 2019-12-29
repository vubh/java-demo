package thread.concurrent.QueueDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模拟生产者消费者
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(1);
        Producter producter = new Producter(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        Thread t1 = new Thread(producter);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();

        //10秒后 停止线程..
        try {
            Thread.sleep(10 * 1000);
            producter.stop();
        } catch (Exception e) {
        }
    }
}

/**
 * 生产者
 */
class Producter implements Runnable {
    private BlockingQueue<String> blockingQueue;
    private AtomicInteger count = new AtomicInteger();
    private volatile boolean flag = true;

    public Producter(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "生产者开始启动...");
        while (flag) {
            String data = count.incrementAndGet() + "";
            try {
                boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (offer) {
                    System.out.println(Thread.currentThread().getName() + ",生产队列" + data + "成功..");
                } else {
                    System.out.println(Thread.currentThread().getName() + ",生产队列" + data + "失败..");
                }
                Thread.sleep(1000);
            } catch (Exception e) {

            }

        }
    }

    public void stop() {
        this.flag = false;
    }

}

/**
 * 消费者
 */
class Consumer implements Runnable {
    private volatile boolean flag = true;
    private BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "消费者开始启动....");
        while (flag) {
            try {
                String data = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (data == null || data == "") {
                    flag = false;
                    System.out.println("消费者超过2秒时间未获取到消息.");
                    return;
                }
                System.out.println("消费者获取到队列信息成功,data:" + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}