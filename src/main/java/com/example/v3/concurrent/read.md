
1、Timer 单线程调用
* 不捕获异常，一个任务出现异常且未被捕获处理，则其他任务不会执行，如果捕获处理了，则其他任务不受影响
* 基于绝对时间，系统时间改变会影响任务执行时间
* 如果一个任务耗时太久或（Thread.sleep()）将导致其他任务的失效性

2、ScheduledThreadPoolExecutor 多线程调用
* 一个任务异常，其他任务不受影响
* 相对时间，不依赖系统时间