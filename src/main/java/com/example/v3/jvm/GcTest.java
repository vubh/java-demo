package com.example.v3.jvm;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class GcTest {
    public static void main(String[] args) {
       /*List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
        list.forEach(b-> System.out.println(b.getName()));*/

        Object obj = new GcTest();

        obj = null;  //对象不可达

        System.gc(); // 提示gc进行回收

    }

    @Override
    protected void finalize() {
        System.out.println("垃圾回收机制...");
    }
}
